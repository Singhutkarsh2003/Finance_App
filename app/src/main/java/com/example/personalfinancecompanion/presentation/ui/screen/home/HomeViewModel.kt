package com.example.personalfinancecompanion.presentation.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalfinancecompanion.domain.usecase.GetTransactionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private  val getTransactionUseCase: GetTransactionUseCase
): ViewModel() {

    private  val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    init {
        loadTransactions()
    }
    private  fun loadTransactions() {
        viewModelScope.launch {
            getTransactionUseCase().collect { list ->
                val income = list.filter { it.type == "income" }.sumOf { it.amount }
                val expense = list.filter { it.type =="expense" }.sumOf { it.amount }

                _state.value = HomeState(
                    transaction = list,
                    totalIncome = income,
                    totalExpense = expense
                )
            }
        }
    }

}