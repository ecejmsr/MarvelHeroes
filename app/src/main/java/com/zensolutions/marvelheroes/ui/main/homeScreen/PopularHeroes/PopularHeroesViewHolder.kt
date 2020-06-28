package com.zensolutions.marvelheroes.ui.main.homeScreen.PopularHeroes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.data.model.heroModel.Character
import com.zensolutions.marvelheroes.util.MarvelHeroesImageUtil

internal class PopularHeroesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.viewholder_popular_hero, parent, false)) {

    private val heroName = itemView.findViewById<TextView>(R.id.TV_popularHeroNameViewholder)
    private val heroImage = itemView.findViewById<ImageView>(R.id.IV_popularHeroImageViewholder)

    fun bind(heroDataWrapper: Character?) {
        heroName.text = heroDataWrapper?.name
        Picasso.get().load(
            MarvelHeroesImageUtil.imgUtil(
                heroDataWrapper?.thumbnail?.path,
                "xlarge",
                heroDataWrapper?.thumbnail?.extension
            )
        ).into(heroImage)
    }
}
