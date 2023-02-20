package com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Question
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz

@Database(
    entities = [
        Quiz::class, Question::class, Answer::class
    ],
    version = 1
)
abstract class QuizDatabase:RoomDatabase(){
    abstract val questionDao:QuestionDao
    abstract val quizDao:QuizDao
}