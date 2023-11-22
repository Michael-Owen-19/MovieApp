package com.michael.movieapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.michael.movieapp.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovie().asLiveData()
}

