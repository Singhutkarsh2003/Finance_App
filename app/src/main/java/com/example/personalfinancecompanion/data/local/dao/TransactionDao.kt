package com.example.personalfinancecompanion.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.personalfinancecompanion.data.local.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao{

    @Insert
    suspend fun insert(transaction : TransactionEntity)

    @Query("SELECT * FROM TransactionEntity ORDER BY date DESC")
    fun getAllTransactions() : Flow<List<TransactionEntity>>

}