package com.ervin.mypokedex.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ervin.mypokedex.data.entity.ModelPokemon
import com.ervin.mypokedex.data.room.PokemonRepository

class MainViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {

    val getPokemon10 : LiveData<PagedList<ModelPokemon>> = pokemonRepository.get10ModelPokemon()


//    fun getAllPokemon(callback: (LiveData<MutableList<ModelPokemon>>)->Unit){
//        Log.d("allpok","here")
//
//        doAsync {
//            var allModelPokemon : LiveData<MutableList<ModelPokemon>>
//            pokemonRepository.test { a ->
//                allModelPokemon = a
//                Log.d("allpok","here2")
//                callback(allModelPokemon)
//            }
//        }
//
//    }
}