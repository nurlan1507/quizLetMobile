package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Delete
import androidx.room.PrimaryKey
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.data_source.QuizDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.repository.QuestionRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.repository.QuizRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuestionRepository
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuizRepository
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRoomDatabase(app:Application):QuizDatabase{
        return Room.databaseBuilder(
            app,
            QuizDatabase::class.java,
            "quiz_db"
        ).build()
    }

    @Provides
    @Singleton
    fun quizRepository(db: QuizDatabase):QuizRepository{
        return QuizRepositoryImpl(db.quizDao)
    }

    @Provides
    @Singleton
    fun questionRepository(db: QuizDatabase): QuestionRepository {
        return QuestionRepositoryImpl(db.questionDao)
    }

    @Provides
    @Singleton
    fun provideQuizUseCases(repository: QuizRepository):QuizUseCases{
        return QuizUseCases(
            getQuiz = GetQuiz(repository),
            getQuizzes = GetQuizzes(repository),
            insertQuiz = InsertQuiz(repository),
            deleteQuiz = DeleteQuiz(repository)
        )
    }

    @Provides
    @Singleton
    fun provideQuestionUseCases(repository: QuestionRepository):QuestionUseCases{
        return QuestionUseCases(
            getQuestionsWithAnswers = GetQuestionsWithAnswers(repository),
            deleteAnswer = DeleteAnswer(repository),
            deleteQuestion = DeleteQuestion(repository),
            insertAnswer = InsertAnswer(repository),
            insertQuestion = InsertQuestion(repository)
        )
    }


}