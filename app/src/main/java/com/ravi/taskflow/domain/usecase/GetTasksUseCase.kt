package com.ravi.taskflow.domain.usecase

import com.ravi.taskflow.domain.model.Task
import com.ravi.taskflow.domain.repository.TaskRepository

class GetTasksUseCase(
    private val repository: TaskRepository
) {
    suspend operator fun invoke(): List<Task> {
        return repository.getTasks()
    }
}
