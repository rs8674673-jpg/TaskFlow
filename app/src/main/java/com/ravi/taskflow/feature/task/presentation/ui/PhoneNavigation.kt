package com.ravi.taskflow.feature.task.presentation.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ravi.taskflow.core.navigation.NavRoutes
import com.ravi.taskflow.feature.task.viewmodel.TaskSharedViewModel

@Composable
fun PhoneNavigation() {

    val navController = rememberNavController()
    val viewModel: TaskSharedViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.DASHBOARD
    ) {

        composable(NavRoutes.DASHBOARD) {
            DashboardScreen(
                viewModel = viewModel,
                onTaskClick = {
                    navController.navigate(NavRoutes.DETAIL)
                }
            )
        }

        composable(NavRoutes.DETAIL) {
            DetailScreen(viewModel)
        }
    }
}
