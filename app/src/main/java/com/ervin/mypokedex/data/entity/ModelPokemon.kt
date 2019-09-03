package com.ervin.mypokedex.data.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.ervin.mypokedex.utils.TablePokemon
import com.ervin.mypokedex.utils.TableTypePokemon

class ModelPokemon {
    @Embedded
    lateinit var pokemon: Pokemon

    @Relation(parentColumn = TablePokemon.PokemonID, entityColumn = TableTypePokemon.TypePokemonID)
    lateinit var pokemonType: List<PokemonType>
}
//{
//    constructor() : this(Pokemon(0,""), List<PokemonType>())
//}