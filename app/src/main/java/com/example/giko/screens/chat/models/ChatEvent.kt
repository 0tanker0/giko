package com.example.giko.screens.chat.models


sealed class ChatEvent {
    data class SaveClicked(val msg: Message): ChatEvent()
    data class Replied(val msg: Message): ChatEvent()
    data class Deleted(val msg: Message): ChatEvent()
    data class OnEdit(val msg: Message): ChatEvent()
}