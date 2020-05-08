package com.zensolutions.marvelheroes.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import com.zensolutions.marvelheroes.data.model.Character

@Parcelize
class CharacterDataContainer(val offset: Int?, val limit: Int?, val total: Int?, val count: Int?, val results: List<Character?>?): Parcelable
