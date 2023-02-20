# Navigation drawer example/ reusable

## steps to use this component
1. Copy and paste CustomNavDrawer.kt file 
2. Create navigation item list
   
    _here itemClick will invoke here after item is clicked you can add your desired destination from here_
3. Copy this code to add nav drawer on desired screen


   ```
   
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
                    items = prepareNavigationDrawerItems(),
                   // headerItem = NavHeader(),
                   coroutineScope =  coroutineScope,
                  scaffoldState =   scaffoldState
                )
            }
        ) {

        }
   }
   ```


#note:

_You can create a custom nav header and pass composable function_

