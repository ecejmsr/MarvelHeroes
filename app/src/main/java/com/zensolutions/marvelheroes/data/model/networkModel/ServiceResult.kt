package com.zensolutions.marvelheroes.data.model.networkModel

import java.lang.Exception

sealed class ServiceResult<out R> {
    data class Success<out T>(val data: T) : ServiceResult<T>()
    data class Error(val exception: Exception) : ServiceResult<Nothing>()
}
