package com.zensolutions.marvelheroes.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zensolutions.marvelheroes.data.model.heroModel.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.network.repo.MarvelHeroFetchRepository
import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class HomeScreenViewModel(private val marvelHeroRepository: MarvelHeroFetchRepository) :
    ViewModel() {
    private val characterDataWrapperMutableLiveData = MutableLiveData<CharacterDataWrapper?>()
    val characterDataWrapperLiveData: LiveData<CharacterDataWrapper?>? =
        characterDataWrapperMutableLiveData

    fun fetchCharacter() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
               handleHeroResponse(marvelHeroRepository.getHeroInformation())
            }
        }
    }

    private fun handleHeroResponse(response: ServiceResult<CharacterDataWrapper>){
        when(response){
            is ServiceResult.Success -> characterDataWrapperMutableLiveData.postValue(response.data)

            is ServiceResult.Error -> response.exception
        }
    }
}
