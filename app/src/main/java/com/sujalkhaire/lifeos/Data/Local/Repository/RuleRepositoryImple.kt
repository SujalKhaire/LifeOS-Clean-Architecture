package com.sujalkhaire.lifeos.Data.Local.Repository

import com.sujalkhaire.lifeos.Data.Local.Dao.RuleDao
import com.sujalkhaire.lifeos.Data.Local.Entity.RuleEntity
import com.sujalkhaire.lifeos.Domain.repository.RuleRepository
import com.sujalkhaire.lifeos.Domain.repository.model.Rule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RuleRepositoryImple @Inject constructor(private val ruleDao: RuleDao):RuleRepository
{
    override suspend fun insertRule(rule: Rule) {
        ruleDao.insterRule(RuleEntity(
            conditionType = rule.conditionType,
            message = rule.message,
            threshold = rule.threshold
        ))
    }

    override fun getRules(): Flow<List<Rule>> {
       return ruleDao.getRule().map {
            list-> list.map {
                Rule(
                    conditionType = it.conditionType,
                    message = it.message,
                    threshold = it.threshold
                )
        }
        }
    }
}