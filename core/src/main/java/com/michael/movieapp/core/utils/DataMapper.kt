package com.michael.movieapp.core.utils

import com.michael.movieapp.core.data.source.local.entity.MovieEntity
import com.michael.movieapp.core.data.source.remote.response.MovieResponse
import com.michael.movieapp.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                posterPath = it.posterPath,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                posterPath = it.posterPath,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        MovieEntity(
            movieId = input.movieId,
            title = input.title,
            overview = input.overview,
            releaseDate = input.releaseDate,
            voteAverage = input.voteAverage,
            voteCount = input.voteCount,
            posterPath = input.posterPath,
            isFavorite = input.isFavorite
        )
}