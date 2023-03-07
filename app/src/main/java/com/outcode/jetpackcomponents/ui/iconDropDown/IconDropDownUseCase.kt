package com.outcode.jetpackcomponents.ui.iconDropDown

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.outcode.jetpackcomponents.utils.readMarkdownFile
import io.noties.markwon.Markwon


/**
 * Created by Niken Maharjan on 2023/2/21.
 */
@Composable
fun IconDropDownUseCase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val applicationContext = LocalContext.current.applicationContext
        val context = LocalContext.current
        val scroll = rememberScrollState(0)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(modifier = Modifier.padding(all = 20.dp)) {
                Button(onClick = {
                    val intent = Intent(
                        context,
                        IconDropDownScreen::class.java
                    )
                    context.startActivity(intent)
                }) {
                    androidx.compose.material.Text(text = "Click Here to See Demo")
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                val markdownString = readMarkdownFile(applicationContext, "IconDropDownReadme.md")
                val markwon = Markwon.create(applicationContext)
                val spanned = markwon.toMarkdown(markdownString)

                androidx.compose.material3.Text(
                    text = "${spanned}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .verticalScroll(scroll)
                )
            }
        }
    }
}