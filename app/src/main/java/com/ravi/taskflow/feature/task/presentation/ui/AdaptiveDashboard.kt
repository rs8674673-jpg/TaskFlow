package com.ravi.taskflow.feature.task.presentation.ui

import androidx.compose.runtime.Composable
import com.ravi.taskflow.core.ui.DeviceType
import com.ravi.taskflow.core.ui.rememberDeviceType

@Composable
fun AdaptiveDashboard() {

    val deviceType = rememberDeviceType()

    if (deviceType == DeviceType.PHONE) {

        PhoneNavigation()

    } else {

        TabletNavigation()
    }
}
