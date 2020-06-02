package com.zensolutions.marvelheroes.ui.homeScreen.PopularHeroes

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zensolutions.marvelheroes.MarvelHeroesApplication
import com.zensolutions.marvelheroes.R
import com.zensolutions.marvelheroes.util.BaseFragment
import javax.inject.Inject

class PopularHeroesListFragment : BaseFragment() {

    override val layoutResourceID: Int
        get() = R.layout.fragment_popular_heroes_list

    @Inject
    lateinit var viewModel: PopularHeroesViewmodel

    private lateinit var popularHeroesAdapter: PopularHeroesAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as MarvelHeroesApplication).mainComponent()
            .popularHeroesComponent().inject(this)

        viewModel.populatePopularHeroList()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPopularHeroesAdapter()

        viewModel.popularHeroesList.observe(viewLifecycleOwner, Observer {
            popularHeroesAdapter.setData(it.shuffled())
        })
    }

    private fun setPopularHeroesAdapter() {
        view?.findViewById<RecyclerView>(R.id.RV_popularHeroesList)?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            val recyclerAdapter = PopularHeroesAdapter()
            this@PopularHeroesListFragment.popularHeroesAdapter = recyclerAdapter
            adapter = popularHeroesAdapter
        }
    }
}
