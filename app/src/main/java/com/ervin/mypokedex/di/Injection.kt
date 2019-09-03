package com.ervin.mypokedex.di

import android.app.Application
import com.ervin.mypokedex.data.room.PokemonRepository
import com.ervin.mypokedex.data.room.PokemonRoomDatabase

class Injection {

    companion object{
        fun provideRepository(application: Application): PokemonRepository {
            val pokemonDao = PokemonRoomDatabase.getDatabase(application).dao()
            return PokemonRepository(pokemonDao)
        }
    }

}