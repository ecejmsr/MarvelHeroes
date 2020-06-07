package com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.data.model.heroModel.Character

internal class PopularHeroesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.viewholder_popular_hero, parent, false)) {

    private val heroName = itemView.findViewById<TextView>(R.id.TV_popularHeroNameViewholder)

    fun bind(heroDataWrapper: Character?) {
        heroName.text = heroDataWrapper?.name
    }
}
