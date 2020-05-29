package com.zensolutions.marvelheroes.ui.homeScreen.PopularHeroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.util.Constants
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class PopularHeroesViewmodel @Inject constructor(
    private val marvelHeroRepository: MarvelHeroFetchRepository,
    private val ioDispatcher: CoroutineDispatcher
) :
    ViewModel() {

    private val _popularHeroesList: MutableLiveData<List<CharacterDataWrapper?>> = MutableLiveData()
    val popularHeroesList: LiveData<List<CharacterDataWrapper?>> = _popularHeroesList

    private val popularHeroList = Constants.POPULARHEROES

    fun populatePopularHeroList() {
        //popular hero list fetch and populate list
        //after successful completion start roomDB development
        //dont forget to do DI
    }
}
