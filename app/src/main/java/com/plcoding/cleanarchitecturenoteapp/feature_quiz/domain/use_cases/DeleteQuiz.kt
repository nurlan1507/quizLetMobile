package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuizRepository

class DeleteQuiz(
    private val repository:QuizRepository
) {
    suspend operator fun invoke(quiz: Quiz){
        repository.deleteQuiz(quiz)
    }
}