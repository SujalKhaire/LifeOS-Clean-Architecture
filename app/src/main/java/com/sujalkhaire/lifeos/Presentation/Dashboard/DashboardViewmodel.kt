package com.sujalkhaire.lifeos.Presentation.Dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sujalkhaire.lifeos.Domain.repository.ExpenceRepository
import com.sujalkhaire.lifeos.Domain.repository.focusRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


import javax.inject.Inject

@HiltViewModel
class DashboardViewmodel @Inject constructor(private val focusrepository: focusRepository,
    private val expenceRepository: ExpenceRepository):ViewModel() {
    private val _uiState = MutableStateFlow(DashboardUIState())
    val uiState = _uiState.asStateFlow()

    init {
        combine(focusrepository.getAvgFocusScore(),expenceRepository.getSumAmount()){ focusScore,todaySpent ->
                DashboardUIState(avgFocusScore =focusScore, todaySpent = todaySpent ?:0 , focusStatus = getFocusStatus(focusScore))

        }.onEach {
            _uiState.value = it
        }.launchIn(viewModelScope)

    }

    fun getFocusStatus(score:Int): String {
        return when {
            score < 40 -> "Low Focus Today"

            score < 70->"Average Focus Today"

            else -> "Great Focus Today"
        }
    }
}