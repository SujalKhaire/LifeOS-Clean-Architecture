package com.sujalkhaire.lifeos.Domain.repository.Usecase

import com.sujalkhaire.lifeos.Domain.repository.focusRepository
import com.sujalkhaire.lifeos.Domain.repository.model.FocusSession
import javax.inject.Inject

class SaveFocusSessionUsecase @Inject constructor(private val repository: focusRepository) {
    suspend operator fun invoke(planeMinutes:Int,focusMinutes:Int){
        val score = (planeMinutes / focusMinutes) * 100
        repository.saveSession(FocusSession(planeMinutes,focusMinutes,score,System.currentTimeMillis())
        )
    }
}