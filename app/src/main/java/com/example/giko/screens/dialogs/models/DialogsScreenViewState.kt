package com.example.giko.screens.dialogs.models


sealed class DialogsScreenViewState{
    data class ViewStateInitial(
        val initialData: List<Dialog> = listOf()
    ): DialogsScreenViewState()
}


data class Dialog(val title: String, val date: String, val words: Int)
