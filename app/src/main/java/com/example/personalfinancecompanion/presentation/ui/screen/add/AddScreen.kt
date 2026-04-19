package com.example.personalfinancecompanion.presentation.ui.screen.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddTransactionScreen(
    viewModel: AddTransactionViewModel,
    onSave: () -> Unit
){
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {

        Text(
            "Add Transaction",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = state.title,
            onValueChange = viewModel::onTitleChange,
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.amount,
            onValueChange = viewModel::onAmountChange,
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = state.category,
            onValueChange = viewModel::onCategoryChange,
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row {
            Button(onClick = {
                viewModel.onTypeChange("income") }) {
                Text("Income")
            }
            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = {
                viewModel.onTypeChange("expense") }) {
                Text("Expense")
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            viewModel.saveTransaction()
            onSave()
        },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Transaction")
        }

    }


}