package com.example.giko

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.giko.screens.chat.ChatScreen
import com.example.giko.screens.chat.ChatScreenViewModel
import com.example.giko.screens.dialogs.DialogsScreen
import com.example.giko.screens.dialogs.DialogsScreenViewModel
import com.example.giko.screens.favorite.FavoriteScreen
import com.example.giko.screens.favorite.FavoriteScreenViewModel
import com.example.giko.screens.start.StartScreen
import com.example.giko.ui.theme.GikoTheme
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GikoTheme {
                MainView(mainViewModel)
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainView(
    mainViewModel: MainViewModel
){
    val selectedIndex = remember { mutableStateOf(1) }
    val NavController = rememberNavController()
    Scaffold(
        bottomBar = {
            if (selectedIndex.value < 3){
                BottomNavigation {
                    BottomNavigationItems.forEachIndexed { i, bottomNavigationItem ->
                        BottomNavigationItem(
                            label = { Text(text = bottomNavigationItem.title) },
                            icon = {
                                Icon(
                                    imageVector = bottomNavigationItem.icon,
                                    contentDescription = ""
                                )
                            },
                            selected = selectedIndex.value == i,
                            onClick = {
                                NavController.navigate(bottomNavigationItem.route)
                            }
                        )
                    }
                }
            }
        }
    ) {
        NavHost(navController = NavController, startDestination = "Dialogs"){
            composable("Start") {
                StartScreen(navController = NavController)
                selectedIndex.value = 0
            }
            composable("Dialogs")  {
                val viewModel = hiltViewModel<DialogsScreenViewModel>(ViewModelStoreOwner { ViewModelStore() })
                DialogsScreen(navController = NavController, viewModel)
                selectedIndex.value = 1
            }
            composable("Favorite") {
                val viewModel = hiltViewModel<FavoriteScreenViewModel>(ViewModelStoreOwner{ ViewModelStore()})
                FavoriteScreen(favoriteScreenViewModel =  viewModel, navController = NavController)
                selectedIndex.value = 2
            }
            composable("Chat") {
                val viewModel = hiltViewModel<ChatScreenViewModel>(ViewModelStoreOwner { ViewModelStore() })
                ChatScreen(navController = NavController, chatScreenViewModel = viewModel)
                selectedIndex.value = 3
            }
//            composable("ReadDialog"){
//                ReadDialogScreen(navController = NavController)
//                selectedIndex.value = 4
//            }
        }
    }
}


sealed class Screen( val title: String) {
    object Begin: Screen("Begin")
    object Dialogs: Screen("Dialogs")
    object Favorite: Screen("Favorite")
}

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)

val BottomNavigationItems = listOf(
    BottomNavigationItem(
        title = Screen.Begin.title,
        route = "Start",
        icon = Icons.Outlined.Add
    ),
    BottomNavigationItem(
        title = Screen.Dialogs.title,
        route = "Dialogs",
        icon = Icons.Outlined.List
    ),
    BottomNavigationItem(
        title = Screen.Favorite.title,
        route = "Favorite",
        icon = Icons.Outlined.Favorite
    )
)
