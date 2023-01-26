package com.example.giko.screens.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giko.base.EventHandler
import com.example.giko.screens.chat.models.ChatEvent
import com.example.giko.screens.chat.models.ChatScreenViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatScreenViewModel @Inject constructor() : ViewModel(), EventHandler<ChatEvent>{
    private val _chatScreenViewState: MutableLiveData<ChatScreenViewState> =
        MutableLiveData(ChatScreenViewState.ViewStateInitial())
    val chatScreenViewState: LiveData<ChatScreenViewState> = _chatScreenViewState

    override fun obtainEvent(event: ChatEvent){
        when (val currentViewState = _chatScreenViewState.value) {
            is ChatScreenViewState.ViewStateInitial -> reduce(event, currentViewState)
            else -> {}
        }
    }

    private fun reduce(event: ChatEvent, currentState: ChatScreenViewState.ViewStateInitial){
        when (event){
            is ChatEvent.SaveClicked -> _chatScreenViewState.postValue(
                currentState.copy(initialData = currentState.initialData.plus(event.msg))
            )
            is ChatEvent.Deleted -> _chatScreenViewState.postValue(
                currentState.copy(initialData = currentState.initialData.minus(event.msg))
            )
            else -> _chatScreenViewState.postValue(currentState)
        }
    }

}