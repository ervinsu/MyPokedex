package com.ervin.mypokedex.ui.main

import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ervin.mypokedex.R
import com.ervin.mypokedex.data.entity.ModelPokemon



class MainViewHolder(val view:View) : RecyclerView.ViewHolder(view) {
    private val name : TextView = view.findViewById(R.id.pokeName)
    private val picture : ImageView = view.findViewById(R.id.pokePicture)
    private val container : View = view.findViewById(R.id.container_main_item)

    private var modelPokemon: ModelPokemon? = null

    init {
        view.setOnClickListener {
            modelPokemon?.pokemon?.pokemonID?.let { pokemonID ->
//                val intent = Intent(this, )
//                view.context.startActivity(intent)
            }
        }
    }

    fun bind(modelPokemon: ModelPokemon?) {
        if (modelPokemon == null) {
            val resources = itemView.resources
            name.text = resources.getString(R.string.unknown)
            picture.visibility = View.GONE
        } else {
            showRepoData(modelPokemon)
        }
    }

    private fun showRepoData(modelPokemon: ModelPokemon) {
        this.modelPokemon = modelPokemon
        name.text = modelPokemon.pokemon.pokemonName
//        val int = intArrayOf()
//        for (i in modelPokemon.pokemonType.indices){
//            int.set(i, modelPokemon.pokemonType[i].typeName)
//        }
//        val gd:GradientDrawable = GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf(1,2,3))
    }

    companion object{
        fun create(parent:ViewGroup): MainViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_view_item,parent,false)
            return MainViewHolder(view)
        }
    }
}