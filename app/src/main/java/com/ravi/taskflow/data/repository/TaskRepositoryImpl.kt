package com.ravi.taskflow.data.repository

import com.ravi.taskflow.domain.model.Task
import com.ravi.taskflow.domain.repository.TaskRepository

class TaskRepositoryImpl : TaskRepository {
    private val tasks = mutableListOf<Task>()

    override suspend fun getTasks(): List<Task> {
        return tasks
    }

    override suspend fun addTask(task: Task) {
        tasks.add(task)
    }
}
