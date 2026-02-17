package com.sujalkhaire.lifeos.Data.Local.Repository

import com.sujalkhaire.lifeos.Data.Local.Dao.HabitDao
import com.sujalkhaire.lifeos.Data.Local.Dao.focusDao
import com.sujalkhaire.lifeos.Data.Local.Entity.HabitEntity
import com.sujalkhaire.lifeos.Domain.repository.HabitRepository
import com.sujalkhaire.lifeos.Domain.repository.model.Habit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HabitRepositoryImpl @Inject constructor(private val habitDao: HabitDao,
    private val focusDao: focusDao): HabitRepository {
    override suspend fun addHabit(name:String) {
        habitDao.insertHabit(HabitEntity(name = name,
            lastCompletedDate = 0L, streak = 0, successRate = 0))
    }

    override suspend fun completeHabit(habit: Habit) {
        val focusavg = focusDao.getAvgFocusScore().first()?:0
        val newStreak = if (habit.lastCompletedDate == 0L){
            1
        }
        else{
            habit.streak + 1
        }

        val newSuccessRate = if (focusavg < 40) {
            habit.successRate - 5
        }
        else{
            habit.successRate + 5
        }
        habitDao.updateHabit(HabitEntity(
            name = habit.name,
            lastCompletedDate = System.currentTimeMillis(),
            streak = newStreak,
            successRate = newSuccessRate
        ))
    }

    override fun getHabit(): Flow<List<Habit>> {
      return  habitDao.getAllHabits().map {
            it.map {
                Habit(
                    name = it.name,
                    streak = it.streak,
                    successRate = it.successRate,
                    lastCompletedDate = it.lastCompletedDate
                )
            }
        }
    }
}