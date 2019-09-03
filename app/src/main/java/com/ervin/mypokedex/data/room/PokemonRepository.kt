package com.ervin.mypokedex.data.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ervin.mypokedex.data.entity.ModelPokemon
import com.ervin.mypokedex.data.entity.Pokemon

class PokemonRepository(private val pokemonDao: PokemonDao) {

    @WorkerThread
    suspend fun delete(pokemon: Pokemon){
        pokemonDao.deletePokemon(pokemon)
    }
    fun get10ModelPokemon():LiveData<PagedList<ModelPokemon>>{
        //get from dao
        val tenPokemon = pokemonDao.get10ModelPokemon()

        //get pagedList
        return LivePagedListBuilder(tenPokemon,5).build()
    }


//    fun getAllModelPokemon(): LiveData<MutableList<ModelPokemon>>{
//        var allMutableListModelPokemon: MutableLiveData<MutableList<ModelPokemon>> = MutableLiveData()
//        var listModelPokemon : MutableList<ModelPokemon> = ArrayList()
//        val allPokemon = pokemonDao.getAllPokemon()
//        for(i in allPokemon.indices){
//            listModelPokemon.add(ModelPokemon(allPokemon[i], pokemonDao.getPokemonType(allPokemon[i].pokemonID)))
//        }
//        allMutableListModelPokemon.value = listModelPokemon
//        return allMutableListModelPokemon
//    }
//
//
//    fun test(callback: (LiveData<MutableList<ModelPokemon>>)->Unit){
//        val allMutableListModelPokemon: MutableLiveData<MutableList<ModelPokemon>> = MutableLiveData()
//        val listModelPokemon : MutableList<ModelPokemon> = ArrayList()
//        doAsync {
//            val allPokemon = pokemonDao.getAllPokemon()
//            Log.d("allpok","${allPokemon.size}")
//            for(i in allPokemon.indices){
//                listModelPokemon.add(ModelPokemon(allPokemon[i], pokemonDao.getPokemonType(allPokemon[i].pokemonID)))
//            }
//            allMutableListModelPokemon.postValue(listModelPokemon)
//            callback(allMutableListModelPokemon)
//        }
//    }

}