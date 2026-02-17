package com.sujalkhaire.lifeos.Data.Local.Repository

import com.sujalkhaire.lifeos.Data.Local.Dao.focusDao
import com.sujalkhaire.lifeos.Data.Local.Entity.FocusSessionEntity
import com.sujalkhaire.lifeos.Domain.repository.focusRepository
import com.sujalkhaire.lifeos.Domain.repository.model.FocusSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FocusRepositoryImpl @Inject constructor(private val dao: focusDao):focusRepository {
    override suspend fun saveSession(session: FocusSession) {
        dao.instertsession(FocusSessionEntity(plannedMinutes = session.plannedMinutes,
            focusedMinutes = session.focusedMinutes,
            focusScore = session.focusScore,
            timestamp = session.timestamp))
    }

    override fun getAvgFocusScore(): Flow<Int> {
        return dao.getAvgFocusScore().map { it?:0 }
    }
}