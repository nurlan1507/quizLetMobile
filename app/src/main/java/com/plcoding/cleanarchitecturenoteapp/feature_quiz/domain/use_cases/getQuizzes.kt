package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

import androidx.room.FtsOptions.Order
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuizRepository
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.OrderType
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.QuizOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class GetQuizzes(
    private val repository: QuizRepository
) {
    operator fun invoke(order:QuizOrder = QuizOrder.Date(OrderType.Descending)): Flow<List<Quiz>> {
        return repository.getQuizzes().map { notes ->
            when(order.orderType){
                OrderType.Ascending->{
                    when(order){
                        is QuizOrder.Date -> notes.sortedBy { it.date }
                        is QuizOrder.Title -> notes.sortedBy { it.title }
                    }
                }
                OrderType.Descending ->{
                    when(order){
                        is QuizOrder.Date -> notes.sortedByDescending { it.date }
                        is QuizOrder.Title -> notes.sortedByDescending { it.title }
                    }
                }
            }
        }
    }
}