package com.example.todotask_telesense.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Task::class), version = 1)
abstract class TaskDB :RoomDatabase(){
    abstract fun taskDAO():TaskDAO
}