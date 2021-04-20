package com.balditsyn.stackoveflow.data.local.dao

import androidx.room.*
import com.balditsyn.stackoveflow.data.model.Question
import kotlinx.coroutines.flow.Flow

@Dao
abstract interface QuestionDao {

    @Query("SELECT * FROM question")
    abstract fun getAllQuestions(): Flow<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuestion(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuestions(questions: List<Question>)

}

