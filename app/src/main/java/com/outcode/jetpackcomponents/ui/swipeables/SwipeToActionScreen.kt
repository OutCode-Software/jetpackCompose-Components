package com.outcode.jetpackcomponents.ui.swipeables

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class SwipeToActionScreen : ComponentActivity() {

    var swipeDirection: SwipeDirection? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        swipeDirection = intent.extras?.get("SwipeDirection") as? SwipeDirection
        setContent {
            MainContent()
        }
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Preview
    @Composable
    fun MainContent() {
        val context = LocalContext.current
        val items = remember { mutableStateListOf<Int>() }
        items.addAll(0..10)

        Scaffold(topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (swipeDirection) {
                            SwipeDirection.LEFT -> "Swipe Left"
                            SwipeDirection.RIGHT -> "Swipe Right"
                            else -> "Swipe Left + Right"
                        }
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        onBackPressedDispatcher.onBackPressed()
                    }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }) {
            Column {
                LazyColumn(
                    contentPadding = PaddingValues(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(items.size) {
                        cellItem(number = items[it], context)
                    }
                }
            }
        }
    }

    @Composable
    fun cellItem(number: Int, context: Context) {
        SwipeAbleItemCell(
            number = number,
            swipeDirection = swipeDirection ?: SwipeDirection.BOTH,
            onEditClick = {
                Toast.makeText(context, "Edit button clicked. Position :- $it", Toast.LENGTH_SHORT)
                    .show()
            },
            onDeleteClicked = {
                Toast.makeText(
                    context,
                    "Delete button clicked. Position :- $it",
                    Toast.LENGTH_SHORT
                ).show()
            })
    }
}