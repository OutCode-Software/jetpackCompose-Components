package com.outcode.jetpackcomponents.ui.navBar

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


/**
 * Created by Ayush Shrestha$ on 2022/11/18$.
 */

@Composable
fun CustomToolbar(@StringRes titleResource: Int, modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(start = 20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = titleResource),
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier,
            color = Color.White
        )
    }
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
 fun MyTopAppBar(
    title: String = "App name",
    onNavIconClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavIconClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Open Navigation Drawer"
                )
            }
        }
    )
}
*/
