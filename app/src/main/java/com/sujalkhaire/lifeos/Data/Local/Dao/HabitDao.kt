package com.sujalkhaire.lifeos.Data.Local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sujalkhaire.lifeos.Data.Local.Entity.HabitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitDao {
    @Insert
    suspend fun insertHabit(habitEntity:HabitEntity)

    @Update
    suspend fun updateHabit(habitEntity: HabitEntity)

    @Query("SELECT * from HABITS")
    fun getAllHabits():Flow<List<HabitEntity>>
}