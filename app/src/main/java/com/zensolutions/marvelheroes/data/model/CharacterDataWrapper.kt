package com.zensolutions.marvelheroes.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
class CharacterDataWrapper(
    val code: Int?, val status: String?, val copyright: String?, val attributionText: String?,
    val attributionHTML: String?, val data: CharacterDataContainer?, val etag: String?
) : Parcelable
