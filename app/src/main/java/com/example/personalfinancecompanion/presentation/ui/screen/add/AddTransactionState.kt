package com.example.personalfinancecompanion.presentation.ui.screen.add

data class AddTransactionState(
    val title : String  = "",
    val amount : String  = "",
    val type : String = "expense",
    val category : String = "",
)
