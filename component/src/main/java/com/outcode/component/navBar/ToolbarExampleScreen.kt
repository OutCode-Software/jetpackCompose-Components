@file:OptIn(ExperimentalMaterial3Api::class)

package com.outcode.component.navBar

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.outcode.component.R
import kotlinx.coroutines.launch


/**
 * Created by Ayush Shrestha$ on 2022/11/18$.
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ToolbarExampleScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        androidx.compose.material.Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = {
                MyTopAppBar {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            },
            drawerContent = {
                DrawerContent(
                    items = prepareNavigationDrawerItems(navController),
                    headerItem = NavHeader(),
                    coroutineScope = coroutineScope,
                    scaffoldState = scaffoldState
                )
            }
        ) {
            NavBarImplementationScreen()
        }
    }

}

@Composable
fun NavHeader() {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        // user's image
        Image(
            modifier = Modifier
                .size(size = 80.dp)
                .clip(shape = CircleShape)
                .padding(20.dp),
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Profile Image"
        )

        // user's name
        Text(
            modifier = Modifier
                .padding(top = 12.dp),
            text = "Hermione",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // user's email
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 30.dp),
            text = "hermione@email.com",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Composable
private fun prepareNavigationDrawerItems(
    navController: NavHostController
): List<NavigationDrawerItem> {
    val itemsList = arrayListOf<NavigationDrawerItem>()

    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.ic_launcher_foreground),
            label = "Home",
            itemClick = {
                navController.navigate("nav_bar_implementation")
            }
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.ic_launcher_foreground),
            label = "Messages",
            showUnreadBubble = false,
            itemClick = {

            }
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.ic_launcher_foreground),
            label = "Notifications",
            showUnreadBubble = false,

            itemClick = {

            }
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.ic_launcher_foreground),
            label = "Profile",

            itemClick = {

            }
        )
    )
    itemsList.add(
        NavigationDrawerItem(
            image = painterResource(id = R.drawable.ic_launcher_foreground),
            label = "Payments",

            itemClick = {

            }
        )
    )


    return itemsList
}