package com.balditsyn.stackoveflow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.balditsyn.stackoveflow.data.model.Question
import com.balditsyn.stackoveflow.data.local.dao.QuestionDao

@Database(entities = [Question::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val questionDao: QuestionDao
}
