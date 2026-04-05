package com.ravi.taskflow.feature.task.presentation

import com.ravi.taskflow.domain.model.Task

/**
 * UI state holder
 * Single source of truth for screen
 */
data class TaskUiState(
    val tasks: List<Task> = emptyList(),
    val selectedTask: Task? = null
)
