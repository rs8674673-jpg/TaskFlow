package com.ravi.taskflow.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ravi.taskflow.feature.task.presentation.ui.TaskDetailScreen
import com.ravi.taskflow.feature.task.presentation.ui.TaskRootScreen
import com.ravi.taskflow.feature.task.viewmodel.TaskViewModel

@Composable
fun TaskNavGraph(viewModel: TaskViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoutes.DASHBOARD
    ) {

        /**
         * Dashboard Screen
         */
        composable(NavRoutes.DASHBOARD) {
            TaskRootScreen(
                viewModel = viewModel,
                onTaskClick = { taskId ->
                    navController.navigate(
                        "${NavRoutes.DETAIL}/$taskId"
                    )
                }
            )
        }

        /**
         * Detail Screen
         */
        composable(
            route = "${NavRoutes.DETAIL}/{taskId}"
        ) { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")
            TaskDetailScreen(taskId)
        }
    }
}
