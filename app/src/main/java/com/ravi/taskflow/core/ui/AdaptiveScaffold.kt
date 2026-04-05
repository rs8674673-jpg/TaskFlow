package com.ravi.taskflow.core.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ravi.taskflow.core.navigation.AppNavHost

@Composable
fun AdaptiveScaffold() {

    val deviceType = rememberDeviceType()
    val navController = rememberNavController()

    val currentRoute =
        navController.currentBackStackEntryAsState()
            .value?.destination?.route

    Scaffold(

        // ⭐ PHONE UI
        bottomBar = {
            if (deviceType == DeviceType.PHONE) {
                BottomNavigationBar(
                    navController,
                    currentRoute
                )
            }
        }

    ) { padding ->

        Row {

            // ⭐ TABLET NAVIGATION RAIL
            if (deviceType == DeviceType.TABLET) {

                NavigationRailBar(
                    navController,
                    currentRoute
                )
            }

            // Main Content
            AppNavHost(
                navController,
                Modifier.padding(padding)
            )
        }
    }
}
