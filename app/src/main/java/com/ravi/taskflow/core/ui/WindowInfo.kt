package com.ravi.taskflow.core.ui

import androidx.compose.material3.windowsizeclass.*
import androidx.compose.runtime.Composable
import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity

/**
 * Holds information about screen size.
 * Used to decide Phone / Tablet layout.
 */
data class WindowInfo(
    val widthSizeClass: WindowWidthSizeClass
)

enum class DeviceType {
    PHONE, TABLET
}

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun rememberWindowInfo(): WindowInfo {
    val activity = LocalActivity.current as ComponentActivity

    val windowSizeClass = calculateWindowSizeClass(activity)

    return WindowInfo(widthSizeClass = windowSizeClass.widthSizeClass)
}

@Composable
fun rememberDeviceType(): DeviceType {
    val windowInfo = rememberWindowInfo()
    return if (windowInfo.widthSizeClass == WindowWidthSizeClass.Compact) {
        DeviceType.PHONE
    } else {
        DeviceType.TABLET
    }
}
