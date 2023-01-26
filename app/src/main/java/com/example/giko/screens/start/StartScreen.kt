package com.example.giko.screens.start

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.giko.ui.theme.backgroundColor

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(
    navController: NavController
){
    val online = remember { mutableStateOf(569) }
    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            Text(text = "Let's start Chatting!")
            Text(text = "${online.value} users online")
            Button(
                onClick = {navController.navigate("Chat")}
            ) {
                Text(text = "Start")
            }
        }
    }
}