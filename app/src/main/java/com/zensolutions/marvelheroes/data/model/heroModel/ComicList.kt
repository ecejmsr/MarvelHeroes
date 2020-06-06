package com.zensolutions.marvelheroes.data.model.heroModel

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicList(val available: Int?, val returned: Int?, val collectionURI: String?, val items: List<ComicSummary>): Parcelable
