package com.ninaestoye.findfun.repository

import com.ninaestoye.findfun.data.QuestionDao
import com.ninaestoye.findfun.model.QueryResponse
import com.ninaestoye.findfun.model.Question
import com.ninaestoye.findfun.network.SimpleAPI
import retrofit2.Response

class QuestionRepository constructor(private val api: SimpleAPI, private val questionDao: QuestionDao) {

    val getSavedQuestions = questionDao.getAllQuestions();

    suspend fun getQuestionsByCategory(amount: Int, category: Int, difficulty: String): Response<QueryResponse> {
        return api.fetchQuestions(amount, category, difficulty);
    }

    suspend fun insertQuestions(questions: List<Question>) {
        for (question in questions) {
            questionDao.insertQuestion(question);
        }
    }
}