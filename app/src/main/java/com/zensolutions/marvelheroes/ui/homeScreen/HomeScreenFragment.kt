package com.zensolutions.marvelheroes.ui.homeScreen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.util.BaseFragment

class HomeScreenFragment : BaseFragment() {

    override val layoutResourceID: Int
        get() = R.layout.fragment_home

    private val viewModel: HomeScreenViewModel by lazy {
        createViewModel {
            HomeScreenViewModel(MarvelHeroFetchRepository.getMarvelHeroApi())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tempTextName = view.findViewById<TextView>(R.id.tempTextName)

        viewModel.characterDataWrapperLiveData?.observe(viewLifecycleOwner, Observer {
            tempTextName.text = it?.data?.results?.get(0)?.name
        })

        viewModel.fetchCharacter("Hulk")
        viewModel.fetchCharacter("Thor")
    }
}
