package com.sujalkhaire.lifeos.Data.Local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import com.sujalkhaire.lifeos.Data.Local.Entity.FocusSessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
 interface focusDao{
     @Insert
     suspend fun instertsession(sessionEntity: FocusSessionEntity)

     @Query("SELECT * from focus_entity ORDER BY timestamp DESC")
     fun getAllSession():Flow<List<FocusSessionEntity>>

     @Query("SELECT AVG(focusScore) from focus_entity")
     fun getAvgFocusScore():Flow<Int?>
 }