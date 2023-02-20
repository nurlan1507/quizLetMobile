package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuestionRepository

class DeleteAnswer(private val repository: QuestionRepository) {
    suspend operator fun invoke(answer:Answer){
        repository.deleteAnswer(answer)
    }
}