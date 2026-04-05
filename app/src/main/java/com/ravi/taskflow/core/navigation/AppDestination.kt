package com.ravi.taskflow.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * All app screens
 */
sealed class AppDestination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Dashboard :
        AppDestination("dashboard", "Dashboard", Icons.Default.Home)

    object Devices :
        AppDestination("devices", "Devices", Icons.Default.Devices)

    object Settings :
        AppDestination("settings", "Settings", Icons.Default.Settings)
}

val navigationItems = listOf(
    AppDestination.Dashboard,
    AppDestination.Devices,
    AppDestination.Settings
)
