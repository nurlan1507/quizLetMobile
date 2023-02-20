package com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.data_source

import androidx.room.*
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.QuestionAndAnswer
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizDao{

    @Query("SELECT * FROM quiz")
    fun getQuizzes():Flow<List<Quiz>>

    @Query("SELECT * FROM quiz where quiz_id =:id")
    suspend fun getQuiz(id:Int):Quiz?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quiz: Quiz)

    @Delete
    suspend fun deleteQuiz(quiz:Quiz)


}