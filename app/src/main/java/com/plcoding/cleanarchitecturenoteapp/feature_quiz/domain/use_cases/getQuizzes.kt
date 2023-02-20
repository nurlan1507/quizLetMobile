package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuizRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetQuizzes(
    private val repository: QuizRepository
) {
    operator fun invoke(id:Int): Flow<List<Quiz>>{
        return repository.getQuizzes()
    }
}