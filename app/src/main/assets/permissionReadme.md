# Permission checker example/ reusable

## steps to use this component
1. Copy and paste permissionHandler.kt file in your code. Which has permission checker code and handles user denied case and navigate to settings page
2. First of all you need to create list of permission you want to take from user eg:
     ```
     val permissions = remember {
        listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }
   
    ```
3. Create instance of permission handler and permission state 
   ```
          val permissionsHandler = remember(permissions) { PermissionsHandler() }
          val permissionsStates by permissionsHandler.state.collectAsState()
   ```
4. Permission checker function initiation
   ```
       HandlePermissionsRequest(permissions = permissions, permissionsHandler = permissionsHandler)
   ```
   
5. Now you can call this when you need permission from user. Here is the example from the button click
   ```
         Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        if (permissionsStates.multiplePermissionsState?.allPermissionsGranted == true) {
            Text(text = "Permission Granted")
        } else {
            Button(onClick = {
                Log.e("click","cliked")
                permissionsHandler.onEvent(PermissionsHandler.Event.PermissionRequired)

            }) {
                Text(text = "Request Permission")
            }
        }
    }
   
   ```