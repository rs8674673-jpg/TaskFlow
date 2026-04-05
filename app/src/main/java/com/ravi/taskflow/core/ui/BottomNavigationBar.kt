package com.ravi.taskflow.core.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ravi.taskflow.core.navigation.AppDestination

@Composable
fun BottomNavigationBar(
    navController: NavController,
    currentRoute: String?
) {
    val navigationItems = listOf(
        AppDestination.Dashboard,
        AppDestination.Devices,
        AppDestination.Settings
    )

    NavigationBar {

        navigationItems.forEach { screen ->

            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo("dashboard")
                        launchSingleTop = true
                    }
                },
                icon = { Icon(screen.icon, null) },
                label = { Text(screen.title) }
            )
        }
    }
}
