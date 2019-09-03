package com.ervin.mypokedex.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ervin.mypokedex.utils.TablePokemon

@Entity(tableName = TablePokemon.PokemonTable)
data class Pokemon(
    @PrimaryKey
    @ColumnInfo(name = TablePokemon.PokemonID)
    var pokemonID: Int,
    @ColumnInfo(name = TablePokemon.PokemonName)
    var pokemonName: String)