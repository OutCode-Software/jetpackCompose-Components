package com.outcode.jetpackcomponents.ui.swipeables

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.outcode.jetpackcomponents.utils.readMarkdownFile
import io.noties.markwon.Markwon

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SwipeableListUseCase() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "Swipeable List UseCase"
                        )
                    },
                )
            }
        ) {
            SwipeableListUseCaseDesc()
        }
    }
}

@Preview
@Composable
fun SwipeableListUseCaseDesc() {
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
                    SwipeableItemDemoScreen::class.java
                )
                context.startActivity(intent)
            }) {
                Text(text = "Click Here to See Demo")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            val markdownString = readMarkdownFile(applicationContext, "swipeableReadme.md")
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