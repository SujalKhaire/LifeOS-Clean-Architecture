package com.sujalkhaire.lifeos.Data.Local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sujalkhaire.lifeos.Data.Local.Entity.ExpenseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expenseEntity: ExpenseEntity)

    @Query("SELECT * from expenses ORDER BY timeStamp DESC")
    fun getExpenses():Flow<List<ExpenseEntity>>

    @Query("""
    SELECT SUM(amount) 
    FROM expenses 
    WHERE date(timeStamp / 1000, 'unixepoch') = date('now')
""")
    fun sumAmount(): Flow<Int?>


}