package com.ninaestoye.findfun.viewModel

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninaestoye.findfun.model.Question
import com.ninaestoye.findfun.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class QuestionViewModel @Inject constructor(private val questionRepository: QuestionRepository, private @Named("auth_token") val token: String) : ViewModel() {

    private val TAG = QuestionViewModel::class.simpleName;
    private val TIME_OUT: Long = 30; // 10 SECS
    private val ONE_SECOND: Long = 1000;
    private lateinit var timer: CountDownTimer;
    
    //val fetchedQuestions : MutableLiveData<Response<QueryResponse>> = MutableLiveData();
    val getSavedQuestions : LiveData<List<Question>> = questionRepository.getSavedQuestions;
    var currentIndex = 0;
    var currentTime : MutableLiveData<Long> = MutableLiveData();
    
    init {
        Log.d(TAG, "init: start timer");
        setCurrent(0);
    }

    fun getQuestionsByCategory(amount: Int, category: Int, difficulty: String) {
        viewModelScope.launch {
            val response = questionRepository.getQuestionsByCategory(amount, category, difficulty);
            //fetchedQuestions.value = response;
            if (response.isSuccessful) {
                response.body()?.results?.let { questions ->
                    Log.d(TAG, "getQuestionsByCategory: questions=${questions}")
                    if (questions.isNotEmpty()) {
                        questionRepository.insertQuestions(questions);
                    }
                }
            }
        }
    }

    fun setCurrent(currentIndex: Int) {
        Log.d(TAG, "setCurrent: currentIndex=${currentIndex}")
        this.currentIndex = currentIndex;
        loadQuestionTimer();
    }

    private fun resetTime() {
        if (::timer.isInitialized) {
            timer.cancel();
            viewModelScope.launch {
                currentTime.value = TIME_OUT;
            }
        }
    }

    fun loadQuestionTimer() {
        Log.d(TAG, "loadQuestionTimer: called ..");
        resetTime();
        timer = object : CountDownTimer(ONE_SECOND * TIME_OUT, ONE_SECOND) {
            override fun onTick(p0: Long) {
                viewModelScope.launch {
                    currentTime.value = p0/ONE_SECOND;
                }
            }

            override fun onFinish() {

            }
        }
        timer.start();
    }

    override fun onCleared() {
        super.onCleared()
        resetTime();
    }
}