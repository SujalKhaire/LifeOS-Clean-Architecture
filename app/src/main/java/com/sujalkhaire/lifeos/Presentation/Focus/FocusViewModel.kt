package com.sujalkhaire.lifeos.Presentation.Focus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sujalkhaire.lifeos.Domain.repository.Usecase.SaveFocusSessionUsecase
import com.sujalkhaire.lifeos.Domain.repository.focusRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FocusViewModel @Inject constructor(private val saveFocusSession: SaveFocusSessionUsecase,private val repository: focusRepository):ViewModel()
{
    private val _avgScore = MutableStateFlow(0)
    val avgScore = _avgScore.asStateFlow()

    init {
        repository.getAvgFocusScore()
            .onEach { _avgScore.value = it }
            .launchIn(viewModelScope)
    }

    fun saveSession(planeMinutes:Int,focusMinutes:Int){
        viewModelScope.launch {
            saveFocusSession(planeMinutes, focusMinutes)
        }
    }
}