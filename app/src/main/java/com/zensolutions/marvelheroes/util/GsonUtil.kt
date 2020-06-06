package com.zensolutions.marvelheroes.util

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(jsonString: String): T? = try {
    this.fromJson<T>(jsonString, object: TypeToken<T>() {}.type)
} catch (e: Exception){
    //Timber.e(Gson error)
    Log.e("Gson() util error", e.message.toString())
    null
}
