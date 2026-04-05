package com.ravi.taskflow.core.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ravi.taskflow.core.navigation.AppDestination

@Composable
fun NavigationRailBar(
    navController: NavController,
    currentRoute: String?
) {
    val navigationItems = listOf(
        AppDestination.Dashboard,
        AppDestination.Devices,
        AppDestination.Settings
    )

    NavigationRail {

        navigationItems.forEach { screen ->

            NavigationRailItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route)
                },
                icon = { Icon(screen.icon, null) },
                label = { Text(screen.title) }
            )
        }
    }
}