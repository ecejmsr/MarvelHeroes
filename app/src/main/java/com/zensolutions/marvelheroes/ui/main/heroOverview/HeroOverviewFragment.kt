package com.zensolutions.marvelheroes.ui.main.heroOverview

import android.content.Context
import android.os.Bundle
import android.view.View
import com.zensolutions.marvelheroes.MarvelHeroesApplication
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.ui.main.homeScreen.HomeScreenViewModel
import com.zensolutions.marvelheroes.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_hero_overview.*
import javax.inject.Inject

class HeroOverviewFragment : BaseFragment() {
//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var viewModel: HomeScreenViewModel

    override val layoutResourceID: Int
        get() = R.layout.fragment_hero_overview

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MarvelHeroesApplication).mainComponent().homeScreenComponent().heroOverviewComponent().inject(this)

        viewModel.characterDataWrapperLiveData
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BT_heroOverviewUnlockHero.setOnClickListener {
            navigate(R.id.tempFragment)
        }
    }
}
