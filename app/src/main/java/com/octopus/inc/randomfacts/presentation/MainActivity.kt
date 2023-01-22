package com.octopus.inc.randomfacts.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.octopus.inc.randomfacts.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MyMainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel.triviaFromRetrofit.observe(this) { triviaFromRetrofit ->
//            Log.d(TAG, "My data : ${triviaFromRetrofit.text}")
//        }

        viewModel.randomTriviaFromRetrofit.observe(this) { randomTriviaFromRetrofit ->
            Log.d(TAG, "My data : ${randomTriviaFromRetrofit.text}")
        }

//        viewModel.getRandomTriviaFromRetrofit()
//        viewModel.getTriviaFromRetrofit(36)
        viewModel.getFact(36)
        viewModel.getFact(50)
        viewModel.getFact(100)
    }
}