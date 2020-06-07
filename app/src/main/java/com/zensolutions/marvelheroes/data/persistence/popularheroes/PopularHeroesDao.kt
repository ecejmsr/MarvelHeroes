package com.zensolutions.marvelheroes.data.persistence.popularheroes

import androidx.room.*
import com.zensolutions.marvelheroes.data.model.heroModel.Character

@Dao
interface PopularHeroesDao {
    @Insert
    suspend fun insert(character: Character)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(character: Character)

    @Query("SELECT * FROM POPULARHEROES")
    fun getAll(): List<Character>

    @Query("SELECT name FROM POPULARHEROES WHERE id = :id")
    fun findCharacterById(id: Int): String

    @Query("SELECT * FROM POPULARHEROES WHERE id IN (:characterIds)")
    fun loadAllByIds(characterIds: IntArray): List<Character>

    @Query("SELECT * FROM POPULARHEROES WHERE name = :name LIMIT 1")
    fun findByName(name: String): Character?

    @Query("SELECT * FROM POPULARHEROES WHERE name LIKE :name")
    fun findCharactersByName(name: String): List<Character>

    @Insert
    fun insertAll(vararg characters: Character)

    @Delete
    fun delete(character: Character)
}
