package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util

sealed class OrderType{
    object Ascending:OrderType()
    object Descending:OrderType()
}