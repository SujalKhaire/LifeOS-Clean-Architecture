package com.sujalkhaire.lifeos.Presentation.Money

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sujalkhaire.lifeos.Domain.repository.ExpenceRepository
import com.sujalkhaire.lifeos.Domain.repository.Usecase.SaveExpenceUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoneyViewModel @Inject constructor(private val repository: ExpenceRepository,
    private val saveExpenceUsecase: SaveExpenceUsecase):ViewModel()
{
    private val _todaytotal = MutableStateFlow(0)
    val todaytotal = _todaytotal.asStateFlow()

    init {
        repository.getSumAmount().onEach {
            if (it != null) {
                _todaytotal.value = it
            }
        }.launchIn(viewModelScope)
    }

    fun addDummyExpence(){
        viewModelScope.launch {
            saveExpenceUsecase.getExpence(amount = (15..50).random(),"Food")
        }

    }
}