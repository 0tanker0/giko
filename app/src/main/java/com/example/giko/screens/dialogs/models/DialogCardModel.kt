package com.example.giko.screens.dialogs.models

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giko.ui.theme.backgroundColor
import com.example.giko.ui.theme.darkExtraColor
import com.example.giko.ui.theme.extraColor
import com.example.giko.ui.theme.typography

@Composable
fun dialogCard(title: String, date: String, words: Int, NavController: NavController) {
    Box(modifier = Modifier
        .height(90.dp)
        .fillMaxWidth()
        .background(backgroundColor)
        .padding(4.dp)
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            //elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { NavController.navigate("ReadDialog") }
                )
        ) {
            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                extraColor,
                                darkExtraColor
                            )
                        )
                    )
                    .padding(8.dp)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Spacer(Modifier.weight(1.0f))

                        Text(title, style = typography.h1)

                        Spacer(Modifier.weight(1.0f))
                    }

                    Spacer(Modifier.weight(1.0f))
                    Column(horizontalAlignment = Alignment.End) {
                        Spacer(Modifier.weight(1.0f))

                        Text(date, style = typography.h3)

                        Spacer(Modifier.height(8.dp))

                        Text("$words words", style = typography.h4)

                        Spacer(Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}