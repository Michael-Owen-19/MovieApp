package com.michael.movieapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val title: String,
    val overview: String,
    val releaseDate: String,
    val voteAverage: Float,
    val voteCount: Int,
    val posterPath: String,
    val isFavorite: Boolean
) : Parcelable