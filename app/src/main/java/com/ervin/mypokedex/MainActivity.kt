package com.ervin.mypokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.ervin.mypokedex.data.entity.ModelPokemon
import com.ervin.mypokedex.ui.main.MainRecyclerAdapter
import com.ervin.mypokedex.ui.main.MainViewModel
import com.ervin.mypokedex.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel:MainViewModel
    private val adapter = MainRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = obtainViewModel(this)


        initAdapter()

    }

    private fun initAdapter() {
        rv_list_main.adapter = adapter
        rv_list_main.layoutManager = GridLayoutManager(this,2)
        mainViewModel.getPokemon10.observe(this, Observer<PagedList<ModelPokemon>> { all10Pokemon->
            Log.d("allpokemonsize", "${all10Pokemon.size} ${all10Pokemon[0]?.pokemon?.pokemonName}")
            adapter.submitList(all10Pokemon)
            hello.text = "${all10Pokemon.size} ${all10Pokemon[0]?.pokemon?.pokemonName}"
        })
    }

    private fun obtainViewModel(activity: MainActivity):MainViewModel{
        val factory: ViewModelFactory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(MainViewModel::class.java)
    }
}
