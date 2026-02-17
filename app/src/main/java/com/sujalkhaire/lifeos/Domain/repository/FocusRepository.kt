package com.sujalkhaire.lifeos.Domain.repository

import com.sujalkhaire.lifeos.Domain.repository.model.FocusSession
import kotlinx.coroutines.flow.Flow

interface focusRepository{
    suspend fun saveSession(session: FocusSession)
    fun getAvgFocusScore():Flow<Int>
}