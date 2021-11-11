package com.ninaestoye.findfun.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
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
    
    //val fetchedQuestions : MutableLiveData<Response<QueryResponse>> = MutableLiveData();
    val getSavedQuestions : LiveData<List<Question>> = questionRepository.getSavedQuestions;

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


}