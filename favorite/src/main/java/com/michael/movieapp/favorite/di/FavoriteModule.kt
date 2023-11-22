package com.michael.movieapp.favorite.di

import com.michael.movieapp.favorite.FavoritesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoritesViewModel(get()) }
}