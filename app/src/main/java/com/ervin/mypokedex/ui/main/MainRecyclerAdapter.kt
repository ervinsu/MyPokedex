package com.ervin.mypokedex.ui.main


import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ervin.mypokedex.data.entity.ModelPokemon

class MainRecyclerAdapter:PagedListAdapter<ModelPokemon, RecyclerView.ViewHolder>(DATA_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val modelPokemonItem = getItem(position)
        if(modelPokemonItem!=null){
            (holder as MainViewHolder).bind(modelPokemonItem)
        }
    }

    companion object{
        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<ModelPokemon>(){
            override fun areItemsTheSame(oldItem: ModelPokemon, newItem: ModelPokemon): Boolean =
                oldItem.pokemon.pokemonID == newItem.pokemon.pokemonID

            override fun areContentsTheSame(oldItem: ModelPokemon, newItem: ModelPokemon): Boolean =
                oldItem.pokemon == newItem.pokemon
        }
    }
}