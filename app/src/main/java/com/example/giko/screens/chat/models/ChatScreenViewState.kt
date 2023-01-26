package com.example.giko.screens.chat.models


sealed class ChatScreenViewState {
    data class ViewStateInitial(
        val hostId: Long = 0,
        val guestId: Long = 1,
        val isHostTyping: Boolean = false,
        val isGuestTyping: Boolean = false,
        val initialData: List<Message> = listOf()
    ): ChatScreenViewState()
}