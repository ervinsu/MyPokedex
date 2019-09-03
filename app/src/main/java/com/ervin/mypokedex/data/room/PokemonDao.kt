package com.ervin.mypokedex.data.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.ervin.mypokedex.data.entity.ModelPokemon
import com.ervin.mypokedex.data.entity.Pokemon
import com.ervin.mypokedex.data.entity.TypeClass
import com.ervin.mypokedex.data.entity.PokemonType

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPokemon(pokemon: Pokemon)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertType(type: TypeClass)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBridgingTypePokemon(pokemonType: PokemonType)

    @Query("Select * from Pokemon where PokemonName = :pokemonName")
    fun getSpesificPokemon(pokemonName:String) : LiveData<Pokemon>
//    SELECT po.*, tp.* from Pokemon po join PokemonType tp on po.PokemonID = tp.TypePokemonID limit 10
//    @Query("SELECT * from Pokemon limit 10")
//    fun get10ModelPokemon() : LiveData<List<ModelPokemon>>

    @Query("SELECT * from Pokemon limit 10")
    fun get10ModelPokemon() : DataSource.Factory<Int, ModelPokemon>

    @Query("Select * from Pokemon po limit 10")
    fun getAllPokemon() : MutableList<Pokemon>

    @Query("Select * from PokemonType where TypePokemonID = :pokemonID")
    fun getTypePokemon(pokemonID: Int) : MutableList<PokemonType>

    @Delete
    fun deletePokemon(pokemon: Pokemon)
}