package com.example.giko.screens.dialogs.models

sealed class DialogsEvent {
    data class Opened(val dialog: Dialog): DialogsEvent()
    data class Starred(val dialog: Dialog): DialogsEvent()
}
