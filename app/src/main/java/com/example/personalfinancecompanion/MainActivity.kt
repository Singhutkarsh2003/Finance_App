package com.example.personalfinancecompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.room.Room
import com.example.personalfinancecompanion.data.local.dao.TransactionRepositoryImpl
import com.example.personalfinancecompanion.data.local.db.AppDatabase
import com.example.personalfinancecompanion.domain.usecase.AddTransactionUseCase
import com.example.personalfinancecompanion.domain.usecase.GetTransactionUseCase
import com.example.personalfinancecompanion.presentation.navigation.NavGraph
import com.example.personalfinancecompanion.presentation.ui.screen.add.AddTransactionViewModel
import com.example.personalfinancecompanion.presentation.ui.screen.home.HomeViewModel
import com.example.personalfinancecompanion.presentation.ui.theme.PersonalFinanceCompanionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "finance_db"
        ).build()

        val repo = TransactionRepositoryImpl(db.transactionDao())

        val homeVM = HomeViewModel(GetTransactionUseCase(repo))
        val addVM = AddTransactionViewModel(AddTransactionUseCase(repo))

        setContent {
            PersonalFinanceCompanionTheme {
                NavGraph(homeVM, addVM)
            }
        }
    }
}

