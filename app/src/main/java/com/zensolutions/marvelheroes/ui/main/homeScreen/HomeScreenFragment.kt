package com.zensolutions.marvelheroes.ui.main.homeScreen

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.zensolutions.marvelheroes.MarvelHeroesApplication
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.util.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeScreenFragment : BaseFragment() {

    override val layoutResourceID: Int
        get() = R.layout.fragment_home

    @Inject lateinit var viewModel: HomeScreenViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        
        (requireActivity().application as MarvelHeroesApplication).mainComponent().inject(this)
        viewModel.fetchCharacter("Thor")

        viewModel.characterDataWrapperLiveData?.observe(this, Observer {
            tempName.text = it?.attributionText
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tempName.setOnClickListener {
            navigate(R.id.heroOverviewFragment)
        }
    }
}
