package com.ervin.mypokedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.ervin.mypokedex.utils.TablePokemon
import com.ervin.mypokedex.utils.TableTypeClass
import com.ervin.mypokedex.utils.TableTypePokemon


@Entity(tableName = TableTypePokemon.TypeTablePokemon,primaryKeys = [TableTypePokemon.TypePokemonID, TableTypePokemon.TypePokemonTypeName])
data class PokemonType (

    @ForeignKey(entity = Pokemon::class,parentColumns = [TablePokemon.PokemonID],childColumns = [TableTypePokemon.TypePokemonID],onDelete = CASCADE)
    @ColumnInfo(name = TableTypePokemon.TypePokemonID)
    var pokemonID:Int,

    @ForeignKey(entity = TypeClass::class,parentColumns = [TableTypeClass.TypeName],childColumns = [TableTypePokemon.TypePokemonTypeName],onDelete = CASCADE)
    @ColumnInfo(name = TableTypePokemon.TypePokemonTypeName)
    var typeName:String)