package com.example.personalfinancecompanion.presentation.ui.screen.home

import com.example.personalfinancecompanion.domain.model.Transaction

data class HomeState(
    val transaction : List<Transaction> = emptyList(),
    val totalIncome : Double = 0.0,
    val totalExpense : Double = 0.0
)
