package com.example.todotask_telesense.database

import androidx.room.*

@Entity(tableName = "Task")
class Task {

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
    var name : String? = null
    var isComplete : Boolean? = null

    constructor(name: String?, isComplete: Boolean?) {
        this.name = name
        this.isComplete = isComplete
    }

}