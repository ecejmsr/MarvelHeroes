package com.zensolutions.marvelheroes.data.model.heroModel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "POPULARHEROES")
data class Character(
    @PrimaryKey
    val id: Int?,
    val name: String?,
    val description: String?,
    val modified: Date?,
    val resourceURI: String?,
    val urls: List<Url>,
    val thumbnail: Image,
    val comics: ComicList,
    val stories: StoryList,
    val events: EventList,
    val series: SeriesList
) : Parcelable
