package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

data class QuizUseCases(
    val getQuizzes: GetQuizzes,
    val getQuiz: GetQuiz,
    val insertQuiz:InsertQuiz,
    val deleteQuiz: DeleteQuiz,
)