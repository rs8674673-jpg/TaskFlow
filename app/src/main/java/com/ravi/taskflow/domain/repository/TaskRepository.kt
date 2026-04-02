package com.ravi.taskflow.domain.repository

import com.ravi.taskflow.domain.model.Task

/**
 * Domain does NOT know how data comes.
 * Database? API? Cache?
 * Doesn't matter.
 */
interface TaskRepository {

    suspend fun getTasks(): List<Task>

    suspend fun addTask(task: Task)
}
