package com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.repository

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.data_source.QuizDao
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow

class QuizRepositoryImpl(
    private val quizDao: QuizDao
) :QuizRepository{
    override fun getQuizzes(): Flow<List<Quiz>> {
        return quizDao.getQuizzes()
    }

    override suspend fun getQuiz(id: Int): Quiz? {
        return quizDao.getQuiz(id)
    }

    override suspend fun insertQuiz(quiz: Quiz) {
        quizDao.insertQuiz(quiz = quiz)
    }

    override suspend fun deleteQuiz(quiz: Quiz) {
        quizDao.deleteQuiz(quiz = quiz)
    }
}