package com.ravi.taskflow.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ravi.taskflow.feature.task.presentation.ui.AdaptiveDashboard

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        startDestination = AppDestination.Dashboard.route,
        modifier = modifier
    ) {

        composable(AppDestination.Dashboard.route) {
            AdaptiveDashboard()
        }

        composable(AppDestination.Devices.route) {
            //DevicesScreen()
        }

        composable(AppDestination.Settings.route) {
            //SettingsScreen()
        }
    }
}