package com.sujalkhaire.lifeos.Domain.repository.Usecase

import com.sujalkhaire.lifeos.Domain.repository.HabitRepository
import com.sujalkhaire.lifeos.Domain.repository.model.Habit
import javax.inject.Inject

class HabitUseCase @Inject constructor(private val repository: HabitRepository) {
    suspend fun addHabit(name:String){
        repository.addHabit(name)
    }

    suspend fun updateHabit(habit: Habit){
        repository.completeHabit(habit)
    }
}