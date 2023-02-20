package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Question
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuestionRepository

class InsertQuestion(private val repository: QuestionRepository) {
    suspend operator fun invoke(question: Question){
        repository.createQuestion(question)
    }
}