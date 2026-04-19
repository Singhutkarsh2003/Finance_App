package com.example.personalfinancecompanion.presentation.ui.screen.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalfinancecompanion.domain.model.Transaction
import com.example.personalfinancecompanion.domain.usecase.AddTransactionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddTransactionViewModel (
    private  val addTransactionUseCase: AddTransactionUseCase
): ViewModel(){

    private  val _state = MutableStateFlow(AddTransactionState())
    val state: StateFlow<AddTransactionState> = _state

    fun onTitleChange(value : String){
        _state.value = _state.value.copy(title = value)
    }
    fun onAmountChange(value : String){
        _state.value = _state.value.copy(amount = value)
    }
    fun onCategoryChange(value: String){
        _state.value = _state.value.copy(category = value)
    }

    fun onTypeChange(value: String) {
        _state.value = _state.value.copy(type = value)
    }

    fun saveTransaction(){
        viewModelScope.launch {
            val transaction = Transaction(
                id = 0,
                title = state.value.title,
                amount = state.value.amount.toDoubleOrNull() ?: 0.0,
                type = state.value.type,
                category = state.value.category,
                date = System.currentTimeMillis()

            )
            addTransactionUseCase(transaction)

            _state.value = AddTransactionState()
        }
    }

}