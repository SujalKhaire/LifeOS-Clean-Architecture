package com.sujalkhaire.lifeos.Domain.repository

import com.sujalkhaire.lifeos.Domain.repository.model.Expences
import kotlinx.coroutines.flow.Flow

interface ExpenceRepository {
    suspend fun addExpense(expences:Expences)
    fun getSumAmount():Flow<Int?>
}