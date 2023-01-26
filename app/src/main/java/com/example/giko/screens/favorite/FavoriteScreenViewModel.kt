package com.example.giko.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giko.fakeData.FakeDialogList
import com.example.giko.screens.dialogs.models.Dialog
import com.example.giko.screens.favorite.models.FavoriteScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class FavoriteScreenViewModel @Inject constructor(): ViewModel() {
    private val _favoriteScreenViewState: MutableLiveData<FavoriteScreenViewState> =
        MutableLiveData(FavoriteScreenViewState.ViewStateInitial())
    val favoriteScreenViewState: LiveData<FavoriteScreenViewState> = _favoriteScreenViewState

    fun getData(): List<Dialog>{
        return FakeDialogList
    }
}