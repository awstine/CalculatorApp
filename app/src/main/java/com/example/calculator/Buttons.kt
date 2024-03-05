package com.example.calculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


//The calculator buttons
@Composable
fun CalcButton(
    character: String,  //all the characters that I will be putting in the button
    modifier: Modifier,
    onclick: ()-> Unit //actions of the buttons
) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onclick() }
            .then(modifier),
    ){
        Text(
            text = character,
            fontSize = 22.sp,
            modifier = Modifier
                .align(Alignment.Center),
            color = Color.Black
        ) //the text that will be displayed in the button

    }
}