package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import kotlinx.coroutines.flow.Flow

interface QuizRepository {
    fun getQuizzes(): Flow<List<Quiz>>
    suspend fun getQuiz(id:Int): Quiz?
    suspend fun insertQuiz(quiz:Quiz)
    suspend fun deleteQuiz(quiz:Quiz)
}