package com.outcode.jetpackcomponents.ui.permission

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


/**
 * Created by Ayush Shrestha$ on 2023/2/15$.
 */
@Composable
fun PermissionCheckerScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Button(onClick = {

        },

        ) {
            Text(text = "Ask Permission")
        }
    }
}