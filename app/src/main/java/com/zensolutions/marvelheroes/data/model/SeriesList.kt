package com.zensolutions.marvelheroes.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
class SeriesList(val available: Int?, val returned: Int?, val collectionURI: String?, val items: List<SeriesSummary>): Parcelable
