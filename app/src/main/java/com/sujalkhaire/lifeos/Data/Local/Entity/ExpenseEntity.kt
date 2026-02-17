package com.sujalkhaire.lifeos.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("expenses")
data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val amount:Int,
    val category: String,
    val timeStamp:Long)
