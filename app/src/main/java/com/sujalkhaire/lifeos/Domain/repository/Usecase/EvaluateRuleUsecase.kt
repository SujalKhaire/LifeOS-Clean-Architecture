package com.sujalkhaire.lifeos.Domain.repository.Usecase

import com.sujalkhaire.lifeos.Domain.repository.RuleRepository
import com.sujalkhaire.lifeos.Domain.repository.focusRepository
import com.sujalkhaire.lifeos.Domain.repository.model.Rule
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class EvaluateRuleUsecase @Inject constructor(private val ruleRepository: RuleRepository,
    private val focusRepository: focusRepository){

    fun evaluate():Flow<List<String>>{
       return combine(
          ruleRepository.getRules(),focusRepository.getAvgFocusScore()
        ){
            rules,score->
            rules.filter {
                rule -> rule.conditionType == "FOCUS_LOW" && score < rule.threshold
            }.map {
                it.message
            }
        }
    }

    suspend fun addExpence(rule: Rule){
        ruleRepository.insertRule(rule)
    }
}