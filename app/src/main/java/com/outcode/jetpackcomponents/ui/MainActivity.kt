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
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.outcode.jetpackcomponents.R
import com.outcode.jetpackcomponents.ui.navBar.CustomToolbar
import com.outcode.jetpackcomponents.ui.navBar.NavBarImplementationScreen
import com.outcode.jetpackcomponents.ui.navBar.ToolbarExampleScreen
import com.outcode.jetpackcomponents.ui.permission.PermissionCheckerScreen
import com.outcode.jetpackcomponents.ui.theme.JetpackComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main_screen") {
                composable("main_screen") { MainScreen(navController) }
                composable("toolbar_example") { ToolbarExampleScreen(navController) }
                composable("Permission_checker") { PermissionCheckerScreen() }
                composable("nav_bar_implementation") { NavBarImplementationScreen() }
            }
            JetpackComponentsTheme {
                // A surface container using the 'background' color from the theme
            }


        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    val listOfComponent = listOf("Navigation bar","Component 1","Component 2","Component 3","Component 4","Component 5")
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = { CustomToolbar(titleResource = R.string.app_name, Modifier) }, content = {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .shadow(AppBarDefaults.TopAppBarElevation)
                            .padding(vertical = 60.dp, horizontal = 20.dp)
                    ) {
                        Text(
                            text = "List of components",
                            color = Color.Black
                        )
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(16.dp),
                            horizontalAlignment = Alignment.Start,

                        ) {
                            itemsIndexed(listOfComponent) { index, item ->
                               Text(
                                    text = item,
                                    modifier = Modifier.padding(vertical = 10.dp).fillMaxWidth()
                                    .clickable {
                                        when(index){
                                            0->{
                                                navController.navigate("toolbar_example")
                                            }
                                            1->{
                                                navController.navigate("Permission_checker")
                                            }
                                        }
                                    },
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}

