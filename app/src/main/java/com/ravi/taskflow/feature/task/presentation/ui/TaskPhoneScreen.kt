package com.ravi.taskflow.feature.task.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ravi.taskflow.feature.task.components.TaskItem
import com.ravi.taskflow.feature.task.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskPhoneScreen(
    viewModel: TaskViewModel,
    onTaskClick: (Int) -> Unit
) {

    val tasks = viewModel.tasks

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TaskFlow") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {

            items(tasks) { task ->
                TaskItem(
                    task = task,
                    onClick = { onTaskClick(it.id) }
                )
            }
        }
    }
}
