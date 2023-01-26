package com.example.giko.screens.dialogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.giko.base.EventHandler
import com.example.giko.fakeData.FakeDialogList
import com.example.giko.fakeData.FakeDialogListX
import com.example.giko.screens.dialogs.models.Dialog
import com.example.giko.screens.dialogs.models.DialogsEvent
import com.example.giko.screens.dialogs.models.DialogsScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DialogsScreenViewModel @Inject constructor(): ViewModel(), EventHandler<DialogsEvent>{
    private val _dialogScreenViewState: MutableLiveData<DialogsScreenViewState> =
        MutableLiveData(DialogsScreenViewState.ViewStateInitial())
    val dialogScreenViewState: LiveData<DialogsScreenViewState> = _dialogScreenViewState

    override fun obtainEvent(event: DialogsEvent) {
        when (val currentViewState = _dialogScreenViewState.value) {
            is DialogsScreenViewState.ViewStateInitial -> reduce(event, currentViewState)
            else -> {}
        }
    }


    private fun reduce(event: DialogsEvent, currentState: DialogsScreenViewState.ViewStateInitial){
        when (event) {
            else -> {}
        }
    }
     fun getData(): List<Dialog>{
        return FakeDialogListX
    }
}