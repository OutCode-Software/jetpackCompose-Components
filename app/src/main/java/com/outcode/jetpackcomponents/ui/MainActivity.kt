package com.outcode.jetpackcomponents.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.outcode.jetpackcomponents.R
import com.outcode.component.horizontalViewPager.CarouselViewUseCase
import com.outcode.component.iconDropDown.IconDropDownUseCase
import com.outcode.component.navBar.CustomToolbar
import com.outcode.component.navBar.NavBarImplementationScreen
import com.outcode.component.navBar.ToolbarExampleScreen
import com.outcode.component.permission.PermissionCheckerScreen
import com.outcode.component.swipeables.SwipeableListUseCase
import com.outcode.jetpackcomponents.ui.theme.JetpackComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val items = mutableStateListOf<Int>()
        items.addAll(0..10)
        setContent {
            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()
            NavHost(navController = navController, startDestination = "main_screen") {
                composable("main_screen") { MainScreen(navController = navController) }
                composable("toolbar_example") {
                   ToolbarExampleScreen(
                        navController
                    )
                }
                composable("Permission_checker") { PermissionCheckerScreen() }
                composable("nav_bar_implementation") { NavBarImplementationScreen() }
                composable("icon_dropdown") { IconDropDownUseCase() }
                composable("carousel_view") { CarouselViewUseCase() }

                composable("swipeable_list_use_case") { SwipeableListUseCase() }
            }
            JetpackComponentsTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen(
        navController: NavController,
    ) {
        val context = LocalContext.current
        val listOfComponent = listOf(
            "Navigation bar",
            "Permission checker",
            "Component 2",
            "Component 3",
            "Component 4",
            "Component 5",
            "Sliding List View",
            "Icon DropDown",
            "Carousel View",
        )
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    CustomToolbar(
                        titleResource = R.string.app_name,
                        Modifier
                    )
                }, content = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.TopStart
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .shadow(AppBarDefaults.TopAppBarElevation)
                                .padding(vertical = 60.dp, horizontal = 20.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(
                                text = "List of components",
                                color = Color.Black
                            )
                            LazyColumn(
                                modifier = Modifier.fillMaxWidth(),
                                contentPadding = PaddingValues(16.dp),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Top,

                                ) {
                                itemsIndexed(listOfComponent) { index, item ->
                                    Text(
                                        text = item,
                                        modifier = Modifier
                                            .padding(vertical = 10.dp)
                                            .fillMaxWidth()
                                            .clickable {
                                                when (index) {
                                                    0 -> {
                                                        navController.navigate("toolbar_example")
                                                    }
                                                    1 -> {
                                                        navController.navigate("Permission_checker")
                                                    }
                                                    6 -> {
                                                        navController.navigate("swipeable_list_use_case")
                                                        /* val intent = Intent(
                                                             context,
                                                             SwipeableItemDemoScreen::class.java
                                                         )
                                                         startActivity(intent)*/
                                                    }
                                                    7 -> {
                                                        navController.navigate("icon_dropdown")

                                                    }
                                                    8 -> {
                                                        navController.navigate("carousel_view")
                                                    }
                                                }
                                            },
                                        textAlign = TextAlign.Start
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

