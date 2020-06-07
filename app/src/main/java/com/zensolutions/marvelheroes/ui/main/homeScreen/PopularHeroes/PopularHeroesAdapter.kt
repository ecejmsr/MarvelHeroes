package com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zensolutions.marvelheroes.data.model.heroModel.Character

internal class PopularHeroesAdapter() : RecyclerView.Adapter<PopularHeroesViewHolder>() {

    private var popularHeroesList: List<Character?>? = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularHeroesViewHolder {
        return PopularHeroesViewHolder(
            LayoutInflater.from(
                parent.context
            ),
            parent
        )
    }

    override fun getItemCount(): Int {
        return popularHeroesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: PopularHeroesViewHolder, position: Int) {
        holder.bind(popularHeroesList?.get(position))
    }

    fun setData(newPopularHeroesList: List<Character?>?){
        this.popularHeroesList = newPopularHeroesList
        notifyDataSetChanged()
    }
}
