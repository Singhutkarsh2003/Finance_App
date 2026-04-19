package com.example.personalfinancecompanion.domain.usecase

import com.example.personalfinancecompanion.domain.repository.TransactionRepository

class GetTransactionUseCase (
    private  val repository: TransactionRepository
){

    operator fun invoke() = repository.getTransactions()

}