package com.example.animemangtoon.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class Favorite(
    @PrimaryKey val title: String,
    val imageUrl: String,
    val description: String
)
