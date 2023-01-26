package com.example.giko.screens.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.giko.screens.dialogs.models.DialogsScreenViewState
import com.example.giko.screens.dialogs.views.DialogsScreenInitial

@Composable
fun DialogsScreen(
    navController: NavController,
    dialogsScreenViewModel: DialogsScreenViewModel
) {
    val viewState = dialogsScreenViewModel.dialogScreenViewState.observeAsState(initial = DialogsScreenViewState.ViewStateInitial())

    when (val state = viewState.value){
        is DialogsScreenViewState.ViewStateInitial ->
            DialogsScreenInitial(
            navController = navController,
            dialogsScreenViewState = state.copy(
                dialogsScreenViewModel.getData()
            )
        )
    }
}