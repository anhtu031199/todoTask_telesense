package com.example.todotask_telesense.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDAO {
    @Query("SELECT * FROM Task")
    fun getAll():List<Task>
    @Query("SELECT * FROM Task where isComplete=1")
    fun getCompleted():List<Task>
    @Insert
    fun insert(task:Task)
    @Delete
    fun delete(task: Task)
}