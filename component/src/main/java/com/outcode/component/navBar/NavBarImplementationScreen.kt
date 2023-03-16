package com.outcode.component.navBar

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.outcode.component.readMarkdownFile
import io.noties.markwon.Markwon
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * Created by Ayush Shrestha$ on 2023/2/15$.
 */
@Composable
fun NavBarImplementationScreen() {
    val applicationContext = LocalContext.current.applicationContext

    val scroll = rememberScrollState(0)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            val markdownString = readMarkdownFile(applicationContext, "navReadme.md")
            val markwon = Markwon.create(applicationContext)
            val spanned = markwon.toMarkdown(markdownString)

            Text(
                text = "${spanned}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterStart).verticalScroll(scroll)
            )
        }


    }
}

/*@Composable
fun ReadmeContent(readmeText: String) {
    val htmlString = Txtmark.process(readmeText)
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { WebView(it) },
        update = {
            it.webViewClient = WebViewClient()
            it.loadData(htmlString, "text/html", "UTF-8")
        }
    )
}*/

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




