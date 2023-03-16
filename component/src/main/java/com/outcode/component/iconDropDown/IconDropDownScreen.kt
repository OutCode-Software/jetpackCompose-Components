package com.outcode.component.iconDropDown

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.noties.markwon.Markwon


/**
 * Created by Niken Maharjan on 2023/2/21.
 */


class IconDropDownScreen : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IconDropDownImpl()
        }
    }
}

@Composable
fun IconDropDownImpl() {
    val countryList = listOf("Nepal", "USA", "JAPAN", "CHINA")
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        val applicationContext = LocalContext.current.applicationContext
        IconDropDown(
            countryList,
            "Select Country",
            false,
            Icons.Filled.Home,
            true,
            Icons.Filled.Home
        ) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        }
    }
}