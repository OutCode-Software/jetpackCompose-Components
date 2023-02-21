package com.outcode.jetpackcomponents.ui.navBar

import android.system.Os.open
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.jeziellago.compose.markdowntext.MarkdownText
import java.io.File
import java.io.InputStream
import java.nio.channels.DatagramChannel.open


/**
 * Created by Ayush Shrestha$ on 2023/2/15$.
 */
@Composable
fun NavBarImplementationScreen() {
    val applicationContext = LocalContext.current.applicationContext

    // val inputStream: InputStream = assets.open("readme.md")
    val file = File(applicationContext.filesDir, "readme.md")

     //val readmeContents = File("readme.md").readText()
    //val file = File("readme.md")
    if (file.exists()) {
        // File exists, read its contents
        Log.e("NavBarImplemnScreen", "exist")
        val contents = file.readText()
    } else {
        // File doesn't exist
        Log.e("NavBarImplemnScreen", "not exist")
    }
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
                .background(color = androidx.compose.ui.graphics.Color.White),
        ) {
            Text(
                text = "How to implement this component",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterStart)

            )
        }

        MarkdownText(markdown = "readmeContents")


    }
}

