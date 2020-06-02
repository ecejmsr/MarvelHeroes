package com.zensolutions.marvelheroes.ui.homeScreen

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import com.zensolutions.marvelheroes.MarvelHeroesApplication
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.util.BaseFragment
import javax.inject.Inject

class HomeScreenFragment : BaseFragment() {

    override val layoutResourceID: Int
        get() = R.layout.fragment_home

    @Inject lateinit var viewModel: HomeScreenViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as MarvelHeroesApplication).mainComponent().homeScreenComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tempTextName = view.findViewById<TextView>(R.id.tempTextName)

        viewModel.characterDataWrapperLiveData?.observe(viewLifecycleOwner, Observer {
            tempTextName.text = it?.data?.results?.get(0)?.name
        })
    }
}
