package com.zensolutions.marvelheroes.data.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.zensolutions.marvelheroes.data.model.heroModel.*
import com.zensolutions.marvelheroes.util.fromJson
import java.util.*

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun dateToTimestamp(date: Date?): Long? {
            return date?.time
        }

        @TypeConverter
        @JvmStatic
        fun fromTimestamp(value: Long?): Date? {
            return if (value == null) null else Date(value)
        }


        @TypeConverter
        @JvmStatic
        fun urlClassToString(url: MutableList<Url>?): String?{
            return Gson().toJson(url)
//            return url?.map { it.type + it.type }?.joinToString { "," }
        }

        @TypeConverter
        @JvmStatic
        fun stringToUrlClass(urlString: String): MutableList<Url>?{
            return Gson().fromJson<MutableList<Url>>(urlString)
//            return urlString?.split(",")?.map { Url(it, "URLtempHolder") }?.toMutableList()
        }

        @TypeConverter
        @JvmStatic
        fun thumbnailClassToString(thumbnail: Image): String?{
            return Gson().toJson(thumbnail)
        }

        @TypeConverter
        @JvmStatic
        fun StringToThumbnailClass(imageString: String): Image?{
            return Gson().fromJson<Image>(imageString)
        }

        @TypeConverter
        @JvmStatic
        fun comicListToString(comicList: ComicList): String?{
            return Gson().toJson(comicList)
        }

        @TypeConverter
        @JvmStatic
        fun stringToComicList(comicListString: String): ComicList?{
            return Gson().fromJson<ComicList>(comicListString)
        }

        @TypeConverter
        @JvmStatic
        fun storyListToString(storyList: StoryList): String?{
            return Gson().toJson(storyList)
        }

        @TypeConverter
        @JvmStatic
        fun stringToStoryList(storyListString: String): StoryList?{
            return Gson().fromJson<StoryList>(storyListString)
        }

        @TypeConverter
        @JvmStatic
        fun eventListToString(eventList: EventList): String?{
            return Gson().toJson(eventList)
        }

        @TypeConverter
        @JvmStatic
        fun stringToEventList(eventListString: String): EventList?{
            return Gson().fromJson<EventList>(eventListString)
        }

        @TypeConverter
        @JvmStatic
        fun seriesListToString(seriesList: SeriesList): String?{
            return Gson().toJson(seriesList)
        }

        @TypeConverter
        @JvmStatic
        fun stringToSeriesList(seriesListString: String): SeriesList?{
            return Gson().fromJson<SeriesList>(seriesListString)
        }
    }

}
