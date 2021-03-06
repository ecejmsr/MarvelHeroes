package com.zensolutions.marvelheroes.data.model.heroModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDataWrapper(
    val code: Int?, val status: String?, val copyright: String?, val attributionText: String?,
    val attributionHTML: String?, val data: CharacterDataContainer?, val etag: String?
) : Parcelable
