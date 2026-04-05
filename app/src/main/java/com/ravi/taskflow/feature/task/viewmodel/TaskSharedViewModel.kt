package com.ravi.taskflow.feature.task.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravi.taskflow.domain.model.Task
import com.ravi.taskflow.domain.repository.TaskRepository
import com.ravi.taskflow.feature.task.presentation.TaskUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskSharedViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    // Internal mutable state
    private val _uiState = MutableStateFlow(TaskUiState())

    // Exposed immutable state
    val uiState: StateFlow<TaskUiState> = _uiState

    init {
        loadTasks()
    }

    /*
     * Load tasks from repository
     */
    private fun loadTasks() {
        viewModelScope.launch {
            val taskList = repository.getTasks()

            _uiState.update {
                it.copy(tasks = taskList)
            }
        }
    }

    /*
     * Called when user selects item
     */
    fun selectTask(task: Task) {
        _uiState.update {
            it.copy(selectedTask = task)
        }
    }
}
