package com.ravi.taskflow.feature.task.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ravi.taskflow.domain.model.Task
import com.ravi.taskflow.feature.task.components.TaskItem
import com.ravi.taskflow.feature.task.viewmodel.TaskSharedViewModel

@Composable
fun DashboardScreen(
    viewModel: TaskSharedViewModel,
    modifier: Modifier = Modifier,
    onTaskClick: (Task) -> Unit = {}
) {

    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(modifier = modifier) {

        items(uiState.tasks) { task ->

            TaskItem(
                task = task,
                onClick = {
                    viewModel.selectTask(task)
                    onTaskClick(task)
                }
            )
        }
    }
}
