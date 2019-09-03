package com.ervin.mypokedex.data.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ervin.mypokedex.data.entity.Pokemon
import com.ervin.mypokedex.data.entity.TypeClass
import com.ervin.mypokedex.data.entity.PokemonType
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = [
    Pokemon::class,
    TypeClass::class,
    PokemonType::class], version = 1)
abstract class PokemonRoomDatabase : RoomDatabase() {
    abstract fun dao():PokemonDao

    companion object{
        @Volatile private var INSTANCE :PokemonRoomDatabase? = null
        private val executorService : ExecutorService = Executors.newSingleThreadExecutor()


        fun getDatabase(context: Context): PokemonRoomDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    PokemonRoomDatabase::class.java,"pokemon_database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                insertJsonFilePokedex(context)
                instance
            }
        }

        private fun loadJsonFile(context: Context, fileJson: String): String {
            val json: String?
            val inputStream: InputStream = context.assets.open(fileJson)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val charset: Charset = Charsets.UTF_8
            json = String(buffer, charset)
            return json
        }

        private fun insertJsonFilePokedex(context: Context){
            var jsonArray = JSONArray(loadJsonFile(context,"pokedex.json"))
            Log.d("allpok","${jsonArray.length()}")

            for (i in 0 until jsonArray.length()){
                val obj:JSONObject = jsonArray.getJSONObject(i)
                val objName : JSONObject = obj.getJSONObject("name")
                val objTypes : JSONArray = obj.getJSONArray("type")
                insertPokemon(Pokemon(obj.getInt("id"),objName.getString("english")))
                for( j in 0 until objTypes.length()){
                    insertBridgingTypePokemon(PokemonType(obj.getInt("id"), objTypes.getString(j)))
                }
            }

            jsonArray = JSONArray(loadJsonFile(context,"types.json"))
            for (i in 0 until jsonArray.length()){
                val obj:JSONObject = jsonArray.getJSONObject(i)
                insertType(TypeClass(i,obj.getString("english")))
            }
        }

        private fun insertPokemon(pokemon:Pokemon){
            executorService.execute {
                INSTANCE?.dao()?.insertPokemon(pokemon)
            }
        }

        private fun insertType(type:TypeClass){
            executorService.execute {
                INSTANCE?.dao()?.insertType(type)
            }
        }

        private fun insertBridgingTypePokemon(pokemonType:PokemonType){
            executorService.execute {
                INSTANCE?.dao()?.insertBridgingTypePokemon(pokemonType)
            }
        }
    }


}