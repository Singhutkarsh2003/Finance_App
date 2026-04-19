package com.example.personalfinancecompanion.data.local.dao

import com.example.personalfinancecompanion.data.mapper.toDomain
import com.example.personalfinancecompanion.data.mapper.toEntity
import com.example.personalfinancecompanion.domain.model.Transaction
import com.example.personalfinancecompanion.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TransactionRepositoryImpl(
    private val dao: TransactionDao
): TransactionRepository{
    override suspend fun addTransaction(transaction: Transaction) {
        dao.insert(transaction.toEntity())
    }

    override fun getTransactions() =
        dao.getAllTransactions().map { list ->
            list.map { it.toDomain() }
        }

}