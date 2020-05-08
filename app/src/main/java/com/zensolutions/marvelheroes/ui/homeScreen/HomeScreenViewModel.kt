package com.zensolutions.marvelheroes.ui.homeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zensolutions.marvelheroes.data.model.CharacterDataWrapper
import com.zensolutions.marvelheroes.data.network.MarvelApi
import com.zensolutions.marvelheroes.data.network.MarvelHeroRepository
import com.zensolutions.marvelheroes.data.network.NetworkModule
import com.zensolutions.marvelheroes.data.network.ServiceResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class HomeScreenViewModel(private val marvelHeroRepository: MarvelHeroRepository) :
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
