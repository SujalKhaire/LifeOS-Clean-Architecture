package com.sujalkhaire.lifeos.Presentation.Habit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sujalkhaire.lifeos.Domain.repository.HabitRepository
import com.sujalkhaire.lifeos.Domain.repository.Usecase.HabitUseCase
import com.sujalkhaire.lifeos.Domain.repository.model.Habit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(
    private val useCase: HabitUseCase,
    private val repository: HabitRepository
):ViewModel() {
  private val _habits = MutableStateFlow<List<Habit>>(emptyList())
    val habits = _habits.asStateFlow()


    init {
        repository.getHabit().onEach {
            _habits.value = it
        }.launchIn(viewModelScope)
    }

    fun addDummyHabit(){
        viewModelScope.launch {
            useCase.addHabit("workout")
        }

    }

    fun updateHabit(habit: Habit){
        viewModelScope.launch {
            useCase.updateHabit(habit)
        }
    }

}