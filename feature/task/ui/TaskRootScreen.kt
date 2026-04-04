package com.ravi.taskflow.feature.task.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ravi.taskflow.core.ui.rememberWindowInfo
import com.ravi.taskflow.feature.task.viewmodel.TaskViewModel

@Composable
fun TaskRootScreen(
    viewModel: TaskViewModel,
    onTaskClick: (Int) -> Unit
) {

    val windowInfo = rememberWindowInfo()

    when (windowInfo.widthSizeClass) {

        WindowWidthSizeClass.Compact -> {
            // Phone UI
            TaskPhoneScreen(viewModel, onTaskClick)
        }

        WindowWidthSizeClass.Medium -> {
            // Foldable UI
            TaskTabletScreen(viewModel, onTaskClick)
        }

        WindowWidthSizeClass.Expanded -> {
            // Tablet/Desktop UI
            TaskTabletScreen(viewModel, onTaskClick)
        }
    }
}

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
                TaskItem(task, onTaskClick)
            }
        }
    }
}
