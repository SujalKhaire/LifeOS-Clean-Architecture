package com.sujalkhaire.lifeos.Data.Local.Repository

import androidx.room.Insert
import com.sujalkhaire.lifeos.Data.Local.Dao.ExpenseDao
import com.sujalkhaire.lifeos.Data.Local.Entity.ExpenseEntity
import com.sujalkhaire.lifeos.Domain.repository.ExpenceRepository
import com.sujalkhaire.lifeos.Domain.repository.model.Expences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExpenceRepositoryImpl @Inject constructor(private val dao: ExpenseDao):ExpenceRepository {
    override suspend fun addExpense(expences: Expences) {
        dao.insertExpense(
            ExpenseEntity(
            amount = expences.amount,
            category = expences.category,
            timeStamp = expences.timeStamp
        )
        )
    }

     override fun getSumAmount(): Flow<Int?> {
        return dao.sumAmount().map { it?:0 }
    }
}