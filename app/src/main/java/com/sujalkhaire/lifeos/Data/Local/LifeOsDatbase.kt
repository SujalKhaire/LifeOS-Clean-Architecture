package com.sujalkhaire.lifeos.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sujalkhaire.lifeos.Data.Local.Dao.ExpenseDao
import com.sujalkhaire.lifeos.Data.Local.Dao.HabitDao
import com.sujalkhaire.lifeos.Data.Local.Dao.RuleDao
import com.sujalkhaire.lifeos.Data.Local.Dao.focusDao
import com.sujalkhaire.lifeos.Data.Local.Entity.ExpenseEntity
import com.sujalkhaire.lifeos.Data.Local.Entity.FocusSessionEntity
import com.sujalkhaire.lifeos.Data.Local.Entity.HabitEntity
import com.sujalkhaire.lifeos.Data.Local.Entity.RuleEntity

@Database([FocusSessionEntity::class,ExpenseEntity::class,HabitEntity::class,RuleEntity::class], version = 4)
abstract class LifeOsDatbase:RoomDatabase() {
    abstract fun focusDao():focusDao
    abstract fun expenceDao():ExpenseDao
    abstract fun habitDao():HabitDao
    abstract fun ruleDao():RuleDao
}