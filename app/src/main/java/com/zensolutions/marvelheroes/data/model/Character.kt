package com.zensolutions.marvelheroes.data.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
class Character(val id: Int?, val name: String?, val description: String?, val modified: Date?, val resourceURI: String?,
                val urls: List<Url>, val thumbnail: Image, val comics: ComicList, val stories: StoryList,
                val events: EventList, val series: SeriesList): Parcelable
