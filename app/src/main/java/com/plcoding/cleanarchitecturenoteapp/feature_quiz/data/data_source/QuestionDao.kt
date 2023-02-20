package com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Answer
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Question
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.QuestionAndAnswer
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions")
    fun getQuestions():Flow<List<Question>>

    @Query("SELECT * FROM questions where quiz_id = :quizId")
    fun getQuestionsWithAnswers(quizId:Int): Flow<List<QuestionAndAnswer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createQuestion(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAnswer(answer: Answer)

    @Delete
    suspend fun deleteQuestion(question:Question)

    @Delete
    suspend fun deleteAnswer(answer:Answer)
}