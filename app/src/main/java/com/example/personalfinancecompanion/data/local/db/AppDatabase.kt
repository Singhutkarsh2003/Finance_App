package com.example.personalfinancecompanion.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.personalfinancecompanion.data.local.dao.TransactionDao
import com.example.personalfinancecompanion.data.local.entity.TransactionEntity


@Database(entities = [TransactionEntity::class], version = 1)
abstract class AppDatabase  : RoomDatabase(){
    abstract  fun transactionDao (): TransactionDao
}