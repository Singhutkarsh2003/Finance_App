package com.example.personalfinancecompanion.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.personalfinancecompanion.presentation.ui.screen.add.AddTransactionScreen
import com.example.personalfinancecompanion.presentation.ui.screen.add.AddTransactionViewModel
import com.example.personalfinancecompanion.presentation.ui.screen.home.HomeScreen
import com.example.personalfinancecompanion.presentation.ui.screen.home.HomeViewModel

@Composable
fun NavGraph(
    homeViewModel: HomeViewModel,
    addViewModel : AddTransactionViewModel
){

    val navController = rememberNavController()

    NavHost(navController , startDestination = Screen.Home.route) {

        composable(Screen.Home.route){
            HomeScreen(viewModel = homeViewModel,
                onAddClick = {navController.navigate(Screen.Add.route)}
                )
        }

        composable(Screen.Add.route){
            AddTransactionScreen(
                viewModel = addViewModel,
                onSave = {navController.popBackStack()}
            )
        }
    }

}