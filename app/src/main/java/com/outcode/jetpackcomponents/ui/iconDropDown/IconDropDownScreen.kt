package com.outcode.jetpackcomponents.ui.iconDropDown

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Created by Niken Maharjan on 2023/2/21.
 */
@Composable
fun IconDropDownScreen() {
    val applicationContext = LocalContext.current.applicationContext
    val countryList = listOf("Nepal", "USA", "JAPAN", "CHINA")
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = "Implementation of IconDropDown", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 17.sp))
        Text(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 0.dp),
            style = TextStyle(fontWeight = FontWeight.SemiBold
            ),
            text =
            "IconDropDown(\ncountryList, \nhint = 'Select Country', \nshouldShowIcon = false, \nIcons.Filled.Home, \nshouldShowDropDownIcon = true, \nIcons.Filled.Home) { }"
        )
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