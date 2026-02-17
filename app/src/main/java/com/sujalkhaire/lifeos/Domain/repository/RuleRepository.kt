package com.sujalkhaire.lifeos.Domain.repository

import com.sujalkhaire.lifeos.Domain.repository.model.Rule
import kotlinx.coroutines.flow.Flow

interface RuleRepository {
    suspend fun insertRule(rule: Rule)

    fun getRules():Flow<List<Rule>>
}