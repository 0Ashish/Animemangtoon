package com.example.animemangtoon.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.animemangtoon.model.Favorite
import com.example.animemangtoon.model.Webtoon

@Dao
interface FavoriteDao {
    @Insert
    suspend fun insert(favorite: Favorite)

    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<Favorite>

   @Delete
    suspend fun delete(favorite: Favorite)
}
