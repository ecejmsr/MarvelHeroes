package com.zensolutions.marvelheroes.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
class EventSummary(val resourceURI: String?, val name: String?): Parcelable
