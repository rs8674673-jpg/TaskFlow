package com.ravi.taskflow.feature.task.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ravi.taskflow.feature.task.viewmodel.TaskSharedViewModel

@Composable
fun TabletNavigation() {

    val viewModel: TaskSharedViewModel = hiltViewModel()

    Row {

        // MASTER LIST
        DashboardScreen(
            viewModel = viewModel,
            modifier = Modifier.weight(1f)
        )

        // DETAIL PANE
        DetailScreen(
            viewModel = viewModel,
            modifier = Modifier.weight(2f)
        )
    }
}

