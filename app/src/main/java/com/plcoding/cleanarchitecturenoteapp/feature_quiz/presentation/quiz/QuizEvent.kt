package com.plcoding.cleanarchitecturenoteapp.feature_quiz.presentation.quiz

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.QuizOrder

sealed class QuizEvent{
    data class Order(val quizOrder: QuizOrder):QuizEvent()
    data class DeleteQuiz(val quiz:Quiz):QuizEvent()
    object ToggleOrderSection:QuizEvent()
}