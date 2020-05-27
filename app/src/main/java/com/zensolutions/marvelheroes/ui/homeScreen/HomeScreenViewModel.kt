package com.zensolutions.marvelheroes.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.di.main.MainScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@MainScope
class HomeScreenViewModel @Inject constructor(
    private val marvelHeroRepository: MarvelHeroFetchRepository,
    private val ioDisptacher: CoroutineDispatcher
) :
    ViewModel() {
    private val characterDataWrapperMutableLiveData = MutableLiveData<CharacterDataWrapper?>()
    val characterDataWrapperLiveData: LiveData<CharacterDataWrapper?>? =
        characterDataWrapperMutableLiveData

    fun fetchCharacter(characterName: String) {
        viewModelScope.launch {
            withContext(ioDisptacher) {
                handleHeroResponse(marvelHeroRepository.getHeroInformation(characterName))
            }
        }
    }

    private fun handleHeroResponse(response: ServiceResult<CharacterDataWrapper>) {
        when (response) {
            is ServiceResult.Success -> characterDataWrapperMutableLiveData.postValue(response.data)

            is ServiceResult.Error -> response.exception
        }
    }
}
