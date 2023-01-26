package com.example.giko.screens.favorite.models

import com.example.giko.screens.dialogs.models.Dialog

sealed class FavoriteScreenViewState {
    data class ViewStateInitial(
        val initialData: List<Dialog> = listOf()
    ): FavoriteScreenViewState()
}