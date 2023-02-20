package com.plcoding.cleanarchitecturenoteapp.feature_quiz.presentation.quiz

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.OrderType
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.QuizOrder

data class QuizState(
    val quizzes:List<Quiz> = emptyList(),
    val order:QuizOrder = QuizOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean = false
)
