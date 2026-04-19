package com.example.personalfinancecompanion.data.mapper

import com.example.personalfinancecompanion.data.local.entity.TransactionEntity
import com.example.personalfinancecompanion.domain.model.Transaction

fun TransactionEntity.toDomain() = Transaction(
    id, title, amount, type, category, date
)
fun Transaction.toEntity() = TransactionEntity(
    id, title, amount, type, category, date
)