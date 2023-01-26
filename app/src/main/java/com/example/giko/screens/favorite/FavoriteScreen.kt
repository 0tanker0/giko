package com.example.giko.screens.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.giko.screens.favorite.models.FavoriteScreenViewState
import com.example.giko.screens.favorite.views.FavoriteScreenInitial

@Composable
fun FavoriteScreen(
    navController: NavController,
    favoriteScreenViewModel: FavoriteScreenViewModel
) {
    val viewState = favoriteScreenViewModel.favoriteScreenViewState.observeAsState(initial = FavoriteScreenViewState.ViewStateInitial())

    when (val state = viewState.value) {
        is FavoriteScreenViewState.ViewStateInitial -> FavoriteScreenInitial(
            navController = navController,
            viewState = state.copy(
                initialData = favoriteScreenViewModel.getData()
            )
        )
    }
}