package com.zensolutions.marvelheroes.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zensolutions.marvelheroes.data.model.heroModel.Character

@Database(entities = [Character::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase(): RoomDatabase(){

    abstract fun popularHeroesDao(): PopularHeroesDao

    companion object {
        val DATABASE_NAME: String = "MarvelHeroesDB"
    }
}
