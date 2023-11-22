package com.michael.movieapp.favorite

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.michael.movieapp.core.ui.MovieAdapter
import com.michael.movieapp.detail.DetailMovieActivity
import com.michael.movieapp.favorite.databinding.ActivityFavoriteBinding
import com.michael.movieapp.favorite.di.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoritesViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        supportActionBar?.title = "Movie Map"

        getMovieData()
    }

    private fun getMovieData() {
        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData->
            val uri = Uri.parse("movieapp://detail")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA,selectedData)
            startActivity(Intent(intent))
        }
    
        favoriteViewModel.favoriteMovie.observe(this) { movie ->
            movieAdapter.setData(movie)
            binding.viewEmptyFavorite.visibility = if (movie.isNotEmpty()) View.GONE else View.VISIBLE
        }
    
        with(binding.rvMovie){
            layoutManager = GridLayoutManager(context,2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}