package com.outcode.jetpackcomponents.ui.swipeables

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SwipeableItemDemoScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Preview
    @Composable
    fun MainContent() {
        val context = LocalContext.current
        Scaffold(topBar = {
            TopAppBar(
                title = { Text("Swipe To Action") },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackPressedDispatcher.onBackPressed()
                    }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }, content = {
            Column {
                Button(
                    onClick = {
                        navigateToSwipeToActionActivity(context, SwipeDirection.LEFT)
                    }, modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(), shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Swipe Left",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Button(
                    onClick = {
                        navigateToSwipeToActionActivity(context, SwipeDirection.RIGHT)
                    }, modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(), shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Swipe Right",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
                Button(
                    onClick = {
                        navigateToSwipeToActionActivity(context, SwipeDirection.BOTH)
                    }, modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(), shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Swipe Left + Right",
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        })
    }

    private fun navigateToSwipeToActionActivity(context: Context, swipeDirection: SwipeDirection) {
        val intent = Intent(context, SwipeToActionScreen::class.java)
        intent.putExtra("SwipeDirection", swipeDirection)
        startActivity(intent)
    }
}

enum class SwipeDirection {
    LEFT, RIGHT, BOTH
}