package com.sujalkhaire.lifeos.Domain.repository.Usecase

import android.icu.util.CurrencyAmount
import com.sujalkhaire.lifeos.Domain.repository.ExpenceRepository
import com.sujalkhaire.lifeos.Domain.repository.model.Expences
import javax.inject.Inject

class SaveExpenceUsecase @Inject constructor(private val repository: ExpenceRepository) {
    suspend fun getExpence(amount: Int,category:String){
        repository.addExpense(Expences(amount = amount,
            category = category,
            timeStamp = System.currentTimeMillis()))
    }
}