package com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases

data class QuestionUseCases(
    val getQuestionsWithAnswers: GetQuestionsWithAnswers,
    val insertAnswer: InsertAnswer,
    val insertQuestion: InsertQuestion,
    val deleteQuestion: DeleteQuestion,
    val deleteAnswer: DeleteAnswer
)