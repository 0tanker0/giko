package com.example.giko.screens.dialogs.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giko.screens.dialogs.models.DialogsScreenViewState
import com.example.giko.screens.dialogs.models.dialogCard
import com.example.giko.ui.theme.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DialogsScreenInitial(
    navController: NavController,
    dialogsScreenViewState: DialogsScreenViewState.ViewStateInitial
){
    Scaffold(topBar = {dialogsScreenTopAppBar()}) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(all = 4.dp)
        ) {
            items(items = dialogsScreenViewState.initialData) {
                dialogCard(
                    title = it.title,
                    date = it.date,
                    words = 10,
                    NavController = navController
                )
            }
        }

    }
}





@Composable
fun dialogsScreenTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(primaryColor)
    ) {
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = Color.White
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Search",
                modifier = androidx.compose.ui.Modifier.background(primaryColor)
            )
        }
        Spacer(modifier = Modifier.weight(1.0f))

        Text(text = "Dialogs", style = typography.h2)

        Spacer(modifier = Modifier.weight(1.0f))
        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = primaryColor,
                contentColor = Color.White
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.background(primaryColor)
            )
        }
    }
}
