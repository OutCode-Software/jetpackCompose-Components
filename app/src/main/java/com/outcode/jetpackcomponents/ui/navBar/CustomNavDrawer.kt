package com.outcode.jetpackcomponents.ui.navBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


/**
 * Created by Ayush Shrestha$ on 2022/12/21$.
 */
@Composable
fun DrawerContent(
    items: List<NavigationDrawerItem>,
    headerItem: Unit? = null,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            headerItem
        }

        items(items) { item ->
            NavigationListItem(item = item, coroutineScope, scaffoldState)
        }
    }
}

@Composable
private fun NavigationListItem(
    item: NavigationDrawerItem,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState,
    unreadBubbleColor: Color = Color(0xFF0FFF93),
    textColor: Color = Color.Black,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable {
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
                item.itemClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {

        // icon and unread bubble
        Box {
            if (item.image != null) {
                Icon(
                    modifier = Modifier
                        .padding(all = if (item.showUnreadBubble && item.label == "Messages") 5.dp else 2.dp)
                        .size(size = if (item.showUnreadBubble && item.label == "Messages") 24.dp else 48.dp),
                    painter = item.image,

                    contentDescription = null,
                    tint = Color.Black
                )
            }
            // unread bubble
            if (item.showUnreadBubble) {
                Box(
                    modifier = Modifier
                        .size(size = 8.dp)
                        .align(alignment = Alignment.TopEnd)
                        .background(color = unreadBubbleColor, shape = CircleShape)
                )
            }
        }

        // label
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = item.label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = textColor
        )
    }
}

data class NavigationDrawerItem(
    val image: Painter?,
    val label: String,
    val showUnreadBubble: Boolean = false,
    val itemClick: () -> Unit
)


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