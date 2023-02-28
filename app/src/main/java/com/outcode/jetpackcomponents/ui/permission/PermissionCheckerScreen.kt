package com.outcode.jetpackcomponents.ui.permission

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.outcode.jetpackcomponents.R


/**
 * Created by Ayush Shrestha$ on 2023/2/15$.
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionCheckerScreen() {
    val permissions = remember {
        listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
    val permissionsHandler = remember(permissions) { PermissionsHandler() }
    val permissionsStates by permissionsHandler.state.collectAsState()
    HandlePermissionsRequest(permissions = permissions, permissionsHandler = permissionsHandler)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (permissionsStates.multiplePermissionsState?.allPermissionsGranted == true) {
            Text(text = "Permission Granted")
        } else {
            Button(onClick = {
                Log.e("click","cliked")
                permissionsHandler.onEvent(PermissionsHandler.Event.PermissionRequired)

            }) {
                Text(text = "Request Permission")
            }
        }
    }
}


