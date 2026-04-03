package com.ravi.taskflow.feature.task.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ravi.taskflow.domain.model.Task

/**
 * Reusable Task Item Component
 *
 * This composable is PURE UI.
 * No business logic here.
 *
 * Reusable across:
 * - Phone Screen
 * - Tablet Screen
 * - Future IoT Device List
 */
@Composable
fun TaskItem(
    task: Task,
    onClick: (Task) -> Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        onClick = { onClick(task) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            /**
             * TASK TITLE
             */
            Text(
                text = task.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            /**
             * TASK DESCRIPTION
             */
            Text(
                text = task.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            /**
             * TASK STATUS ROW
             */
            Row {

                if (task.isCompleted) {

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null
                    )

                    Spacer(Modifier.width(6.dp))

                    Text("Completed")

                } else {

                    Icon(
                        imageVector = Icons.Default.Schedule,
                        contentDescription = null
                    )

                    Spacer(Modifier.width(6.dp))

                    Text("Pending")
                }
            }
        }
    }
}
