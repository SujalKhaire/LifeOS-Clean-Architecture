package com.sujalkhaire.lifeos.Data.Local.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rules")
data class RuleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val conditionType: String,
    val threshold: Int,
    val message: String
)
