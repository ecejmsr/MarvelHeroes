package com.zensolutions.marvelheroes.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
class StorySummary(val resourceURI: String?, val name: String?, val type: String?): Parcelable