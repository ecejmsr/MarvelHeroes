package com.zensolutions.marvelheroes.data.model.heroModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SeriesSummary(val resourceURI: String?, val name: String?) : Parcelable
