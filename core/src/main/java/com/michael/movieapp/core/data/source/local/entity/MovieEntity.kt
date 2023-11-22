package com.michael.movieapp.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity (
    @PrimaryKey
    @ColumnInfo(name = "movieId")
    var movieId: Int,
    
    @ColumnInfo(name = "title")
    var title: String,
    
    @ColumnInfo(name = "overview")
    var overview: String,
    
    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,
    
    @ColumnInfo(name = "voteAverage")
    var voteAverage: Float,
    
    @ColumnInfo(name = "voteCount")
    var voteCount: Int,
    
    @ColumnInfo(name = "posterPath")
    var posterPath: String,
    
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
