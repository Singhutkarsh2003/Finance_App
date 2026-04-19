package com.example.personalfinancecompanion.domain.repository

import com.example.personalfinancecompanion.domain.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    suspend fun  addTransaction(transaction: Transaction)
    fun getTransactions(): Flow<List<Transaction>>
}