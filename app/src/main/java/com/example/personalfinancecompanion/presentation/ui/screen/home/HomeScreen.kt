package com.example.personalfinancecompanion.presentation.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onAddClick: () -> Unit
){

    val state by viewModel.state.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onAddClick) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
        ) {
            Text(
                text = "Dashboard",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.height(16.dp)) {

                Card(
                    modifier = Modifier.weight(1f).padding(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Income")
                        Text("${state.totalIncome}")
                    }
                }
                Card(
                    modifier = Modifier.weight(1f).padding(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Expense")
                        Text("${state.totalExpense}")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (state.transaction.isEmpty()){
                Text("No transactions yet")
            }else{
                LazyColumn{
                    items(state.transaction){transactions ->
                        Card(modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Column {
                                    Text(transactions.title)
                                    Text(transactions.category)
                                }
                                Text("$${transactions.amount}")
                            }
                        }

                    }
                }
            }

        }

    }

}