package com.ravi.taskflow.feature.task.presentation.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
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
