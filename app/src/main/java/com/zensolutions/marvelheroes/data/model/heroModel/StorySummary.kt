package com.zensolutions.marvelheroes.data.model.heroModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StorySummary(val resourceURI: String?, val name: String?, val type: String?) : Parcelable
