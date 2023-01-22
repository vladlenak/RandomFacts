package com.octopus.inc.randomfacts.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.octopus.inc.domain.usecases.GetRandomTriviaFromRetrofitUseCase
import com.octopus.inc.domain.usecases.GetTriviaFromRetrofitUseCase
import com.octopus.inc.randomfacts.presentation.mappers.TriviaViewMapper
import com.octopus.inc.randomfacts.presentation.models.TriviaView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTriviaFromRetrofitUseCase: GetTriviaFromRetrofitUseCase,
    private val getRandomTriviaFromRetrofitUseCase: GetRandomTriviaFromRetrofitUseCase
) : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    private val _triviaFromRetrofit = MutableLiveData<TriviaView>()
    private val _randomTriviaFromRetrofit = MutableLiveData<TriviaView>()
    val triviaFromRetrofit: LiveData<TriviaView> = _triviaFromRetrofit
    val randomTriviaFromRetrofit: LiveData<TriviaView> = _randomTriviaFromRetrofit

    fun getTriviaFromRetrofit(id: Int) = viewModelScope.launch {
        _triviaFromRetrofit.value = TriviaViewMapper().mapToEntity(getTriviaFromRetrofitUseCase.execute(id))
    }

    fun getRandomTriviaFromRetrofit() = viewModelScope.launch {
        _randomTriviaFromRetrofit.value = TriviaViewMapper().mapToEntity(getRandomTriviaFromRetrofitUseCase.execute())
    }

    fun getFact(number: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val doc = getJsoupDocument("http://numbersapi.com/$number")
            Log.d(TAG, "getFact: ${doc.body().text()}")

            val res = doc.getElementById("search")
            res?.getElementById("result-temporary-text")?.forEach {
                Log.d(TAG, "getFact: $it")
            }

        }

    }

    private fun getJsoupDocument(baseUrl: String): Document {
        return Jsoup.connect(baseUrl)
            .userAgent("Mozilla/5.0 (Macintosh; anycodings_android-studio Intel Mac OS X 10_9_2) anycodings_android-studio AppleWebKit/537.36 (KHTML, anycodings_android-studio like Gecko) anycodings_android-studio Chrome/33.0.1750.152 Safari/537.36")
            .referrer("http://www.google.com")
            .ignoreContentType(true)
            .timeout(10000)
            .get()
    }
}