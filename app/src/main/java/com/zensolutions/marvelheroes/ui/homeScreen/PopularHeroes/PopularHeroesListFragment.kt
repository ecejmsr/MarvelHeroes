package com.zensolutions.marvelheroes.ui.homeScreen.PopularHeroes

import android.content.Context
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.util.BaseFragment
import javax.inject.Inject

class PopularHeroesListFragment : BaseFragment() {

    override val layoutResourceID: Int
        get() = R.layout.fragment_popular_heroes_list

    @Inject lateinit var viewModel: PopularHeroesViewmodel

    override fun onAttach(context: Context) {
        super.onAttach(context)


    }
}
