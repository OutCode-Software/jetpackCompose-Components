package com.outcode.component.permission

import android.Manifest
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.outcode.component.readMarkdownFile
import io.noties.markwon.Markwon


/**
 * Created by Ayush Shrestha$ on 2023/2/15$.
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionCheckerScreen() {
    val applicationContext = LocalContext.current.applicationContext
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
    val scroll = rememberScrollState(0)

    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        if (permissionsStates.multiplePermissionsState?.allPermissionsGranted == true) {
            Text(text = "Permission Granted")
        } else {
            Button(onClick = {
                Log.e("click", "cliked")
                permissionsHandler.onEvent(PermissionsHandler.Event.PermissionRequired)

            }) {
                Text(text = "Request Permission")
            }
        }
        val markdownString = readMarkdownFile(applicationContext, "permissionReadme.md")
        val markwon = Markwon.create(applicationContext)
        val spanned = markwon.toMarkdown(markdownString)
        Log.e("spanned", "spanned:$spanned")
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "${spanned}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .verticalScroll(scroll)
            )
        }

    }
}





