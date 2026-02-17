package com.sujalkhaire.lifeos.Presentation.Rule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sujalkhaire.lifeos.Domain.repository.Usecase.EvaluateRuleUsecase
import com.sujalkhaire.lifeos.Domain.repository.model.Rule
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RuleViewModel @Inject constructor(private val ruleUsecase: EvaluateRuleUsecase):ViewModel() {
    private val _message = MutableStateFlow<List<String>>(emptyList())
    val message = _message.asStateFlow()

    init {
        ruleUsecase.evaluate().onEach {
            _message.value = it
        }.launchIn(viewModelScope)
    }

    fun addDummyRule(){
        viewModelScope.launch {
            ruleUsecase.addExpence(
                Rule(
                    conditionType = "FOCUS_LOW",
                    threshold = 40,
                    message = "Your focus is low today. Try a break."
                )
            )
        }

    }
}