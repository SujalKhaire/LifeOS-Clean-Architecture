package com.sujalkhaire.lifeos.Data.Local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sujalkhaire.lifeos.Data.Local.Entity.RuleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RuleDao {
    @Insert
    suspend fun insterRule(ruleEntity: RuleEntity)

    @Query("SELECT * from rules")
    fun getRule():Flow<List<RuleEntity>>
}