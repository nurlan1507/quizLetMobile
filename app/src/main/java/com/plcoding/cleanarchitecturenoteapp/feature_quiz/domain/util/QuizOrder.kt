package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util

sealed class QuizOrder (val orderType:OrderType){
    class Title(orderType: OrderType) :QuizOrder(orderType)
    class Date(orderType: OrderType) :QuizOrder(orderType)

    fun copy(orderType: OrderType):QuizOrder{
        return when(this){
            is Title -> Title(orderType)
            is Date -> Date(orderType)
        }
    }
}