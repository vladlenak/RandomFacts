package com.octopus.inc.randomfacts.presentation.trivia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import javax.inject.Inject

@HiltViewModel
class TriviaViewModel @Inject constructor() : ViewModel() {

    private val _trivia = MutableLiveData<String>()
    val trivia: LiveData<String> = _trivia

    fun getFact(number: Int) {
        // TODO переместить в модуль network и сделать usecase
        CoroutineScope(Dispatchers.IO).launch {
            val doc = getJsoupDocument("http://numbersapi.com/$number")
            CoroutineScope(Dispatchers.Main).launch {
                _trivia.value = doc.body().text()
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