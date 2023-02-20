package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuestionRepository
class GetQuestionsWithAnswers(private val repository: QuestionRepository) {
    operator fun invoke(id:Int){
        repository.getQuestionsWithAnswers(id)
    }
}