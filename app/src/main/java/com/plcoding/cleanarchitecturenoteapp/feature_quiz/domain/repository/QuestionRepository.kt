package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Question
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.QuestionAndAnswer
import kotlinx.coroutines.flow.Flow

interface QuestionRepository {
    fun getQuestions():Flow<List<Question>>

    fun getQuestionsWithAnswers(quizId:Int): Flow<List<QuestionAndAnswer>>

    suspend fun createQuestion(question: Question)

    suspend fun addAnswer(answer: Answer)

    suspend fun deleteQuestion(question: Question)

    suspend fun deleteAnswer(answer: Answer)
}