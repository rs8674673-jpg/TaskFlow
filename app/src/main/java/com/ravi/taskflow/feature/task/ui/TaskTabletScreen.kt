package com.ravi.taskflow.feature.task.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ravi.taskflow.R
import com.ravi.taskflow.feature.task.ui.components.TaskItem
import com.ravi.taskflow.feature.task.viewmodel.TaskViewModel

@Composable
fun TaskTabletScreen(
    viewModel: TaskViewModel
) {

    val tasks = viewModel.tasks

    Row(
        modifier = Modifier.fillMaxSize()
    ) {

        /**
         * LEFT PANE
         * Task List
         */
        LazyColumn(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight()
        ) {

            items(tasks) { task ->
                TaskItem(task)
            }
        }

        /**
         * RIGHT PANE
         * Detail Screen Placeholder
         */
        Box(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            Text(stringResource(R.string.select_a_task))
        }
    }
}
