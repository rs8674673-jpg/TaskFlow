package com.ravi.taskflow.feature.task.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.ravi.taskflow.core.ui.rememberWindowInfo
import com.ravi.taskflow.feature.task.viewmodel.TaskViewModel

@Composable
fun TaskRootScreen(
    viewModel: TaskViewModel
) {

    val windowInfo = rememberWindowInfo()

    when (windowInfo.widthSizeClass) {

        WindowWidthSizeClass.Compact -> {
            // Phone UI
            TaskPhoneScreen(viewModel)
        }

        WindowWidthSizeClass.Medium -> {
            // Foldable UI
            TaskTabletScreen(viewModel)
        }

        WindowWidthSizeClass.Expanded -> {
            // Tablet/Desktop UI
            TaskTabletScreen(viewModel)
        }
    }
}


