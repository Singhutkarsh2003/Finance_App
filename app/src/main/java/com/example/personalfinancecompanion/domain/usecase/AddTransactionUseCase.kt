package com.example.personalfinancecompanion.domain.usecase

import com.example.personalfinancecompanion.domain.model.Transaction
import com.example.personalfinancecompanion.domain.repository.TransactionRepository

class AddTransactionUseCase (
    private  val repository: TransactionRepository
){

    suspend  operator fun invoke(transaction: Transaction){
        repository.addTransaction(transaction)
    }

}