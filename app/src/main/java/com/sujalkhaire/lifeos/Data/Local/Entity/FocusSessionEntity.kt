package com.sujalkhaire.lifeos.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("focus_entity")
data class FocusSessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val plannedMinutes: Int,
    val focusedMinutes: Int,
    val timestamp: Long,
    val focusScore: Int
)
