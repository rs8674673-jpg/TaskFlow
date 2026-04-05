package com.ravi.taskflow.feature.task.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ravi.taskflow.domain.model.Task
import com.ravi.taskflow.feature.task.viewmodel.TaskSharedViewModel

@Composable
fun DetailScreen(
    viewModel: TaskSharedViewModel,
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()

    val task = uiState.selectedTask

    if (task == null) {
        EmptyDetail(modifier)
    } else {
        TaskDetailContent(task, modifier)
    }
}

@Composable
fun EmptyDetail(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Select a task to see details",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun TaskDetailContent(
    task: Task,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = task.title,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = task.description,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = if (task.isCompleted) "Status: Completed" else "Status: Pending",
            style = MaterialTheme.typography.labelLarge,
            color = if (task.isCompleted) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
        )
    }
}
