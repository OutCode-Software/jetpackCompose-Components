package com.outcode.jetpackcomponents.ui.navBar

import android.R.attr.password
import android.content.Context
import android.os.Environment
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
import java.io.*
import java.util.*


/**
 * Created by Ayush Shrestha$ on 2023/2/15$.
 */
@Composable
fun NavBarImplementationScreen() {
    val applicationContext = LocalContext.current.applicationContext


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

    }
}

fun readTextFromAssets(context: Context, fileName: String): String {
    val inputStream = context.assets.open(fileName)
    val inputReader = BufferedReader(InputStreamReader(inputStream))
    val stringBuilder = StringBuilder()

    var line: String? = inputReader.readLine()
    while (line != null) {
        stringBuilder.append(line)
        line = inputReader.readLine()
    }

    return stringBuilder.toString()
}


