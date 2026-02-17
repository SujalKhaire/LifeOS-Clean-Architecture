package com.sujalkhaire.lifeos.Domain.repository

import com.sujalkhaire.lifeos.Domain.repository.model.Habit
import kotlinx.coroutines.flow.Flow

interface HabitRepository
{
    suspend fun addHabit(name:String)
    suspend fun completeHabit(habit: Habit)
    fun getHabit():Flow<List<Habit>>
}