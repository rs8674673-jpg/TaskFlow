package com.ravi.taskflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.ravi.taskflow.core.theme.TaskFlowTheme
import com.ravi.taskflow.feature.task.ui.TaskRootScreen
import com.ravi.taskflow.feature.task.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskFlowTheme {
                val viewModel: TaskViewModel = hiltViewModel()
                TaskRootScreen(viewModel)
            }
        }
    }
}