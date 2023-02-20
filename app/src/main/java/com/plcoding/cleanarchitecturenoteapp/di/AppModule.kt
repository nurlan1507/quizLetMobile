package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.PrimaryKey
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.data_source.QuizDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.repository.QuestionRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.data.repository.QuizRepositoryImpl
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuestionRepository
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.repository.QuizRepository
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
}