package com.zensolutions.marvelheroes.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
class EventList(val available: Int?, val returned: Int?, val collectionURI: String?, val items: List<EventSummary>): Parcelable
