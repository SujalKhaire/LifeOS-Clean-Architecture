package com.sujalkhaire.lifeos.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habits")
data class HabitEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val streak: Int,
    val lastCompletedDate: Long,
    val successRate: Int
)
