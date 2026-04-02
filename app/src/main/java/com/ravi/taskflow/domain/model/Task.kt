package com.ravi.taskflow.domain.model

/**
 * Domain Model
 * Pure Kotlin class.
 * No Android dependency.
 */
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)
