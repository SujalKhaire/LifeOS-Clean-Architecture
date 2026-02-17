package com.sujalkhaire.lifeos.Domain.repository.model

data class Habit(
    val id: Int = 0,
    val name: String,
    val streak: Int,
    val successRate: Int,
    val lastCompletedDate: Long
)
