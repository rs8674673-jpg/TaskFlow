package com.ravi.taskflow.data.repository

import com.ravi.taskflow.domain.model.Task
import com.ravi.taskflow.domain.repository.TaskRepository

class TaskRepositoryImpl : TaskRepository {
    private val tasks = mutableListOf(
        Task(1, "Buy groceries", "Milk, eggs, and bread", false),
        Task(2, "Wash car", "Clean the exterior and interior", true),
        Task(3, "Read a book", "Finish reading 'Atomic Habits'", false),
        Task(4, "Workout", "Go to the gym for an hour", true),
        Task(5, "Plan trip", "Research destinations for the summer", false),
        Task(6, "Fix sink", "Repair the leak in the kitchen sink", false),
        Task(7, "Grocery shopping", "Buy fruits and vegetables", true),
        Task(8, "Study Kotlin", "Learn about Coroutines and Flow", false)
    )

    override suspend fun getTasks(): List<Task> {
        return tasks
    }

    override suspend fun addTask(task: Task) {
        tasks.add(task)
    }
}
