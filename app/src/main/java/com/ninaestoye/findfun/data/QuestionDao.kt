package com.ninaestoye.findfun.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.ninaestoye.findfun.model.Question

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question_table")
    fun getAllQuestions() : LiveData<List<Question>>;

    @Query("SELECT * FROM question_table WHERE id = :id")
    fun getQuestion(id: Int) : LiveData<Question>;

    @Query("SELECT * FROM question_table WHERE category = :category")
    fun getQuestionsByCategory(category: Int) : LiveData<Question>;

    //TODO: add question
    @Insert(onConflict = REPLACE)
    suspend fun insertQuestion(question: Question);
}