package com.example.giko.screens.chat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.giko.screens.chat.models.ChatEvent
import com.example.giko.screens.chat.models.ChatScreenViewState
import com.example.giko.screens.chat.views.ChatScreenInitial
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun ChatScreen(
    navController: NavController,
    chatScreenViewModel: ChatScreenViewModel,
) {
    val viewState = chatScreenViewModel.chatScreenViewState.observeAsState(initial = ChatScreenViewState.ViewStateInitial())

    when (val state = viewState.value) {
        is ChatScreenViewState.ViewStateInitial -> ChatScreenInitial(
            navController = navController,
            chatScreenViewState = state,
            onSaveClicked = {chatScreenViewModel.obtainEvent(event = ChatEvent.SaveClicked(it))},
            onReplied = { /*TODO*/ }) {

        }
    }

}