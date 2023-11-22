package com.michael.movieapp.di

import com.michael.movieapp.core.domain.usecase.MovieInteractor
import com.michael.movieapp.core.domain.usecase.MovieUseCase
import com.michael.movieapp.detail.DetailMovieViewModel
import com.michael.movieapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}