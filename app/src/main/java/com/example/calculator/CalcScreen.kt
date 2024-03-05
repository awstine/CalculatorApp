package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalcScreen(
    state: CalcState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalcEvent) -> Unit

) {
    Box (
        modifier = modifier
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.character?: "") + state.number2,
                textAlign = TextAlign.End, //the text will be displayed from the right to the left
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(vertical = 30.dp),
                fontWeight = FontWeight.Light,
                fontSize = 70.sp,
                color = Color.Black,
                maxLines = 2 // text will be displays in two lines
            )
            //Row 1
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalcButton(
                    //Calc event is the calculator operation

                    character = "AC",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .aspectRatio(2f)  //Twice bigger as the normal button
                        .weight(2f),

                    onclick = {
                        onAction(CalcEvent.Clear)
                    },
                )
                CalcButton(
                    character = "DEL",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Delete)
                    }
                )
                CalcButton(
                    character = "/",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Operator(Operations.Divide))
                    }
                )
            }
            //Row 2
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                //Calc event is the calculator operation
                CalcButton(
                    character = "7",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(7))
                    }
                )
                CalcButton(
                    character = "8",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(8))
                    }
                )
                CalcButton(
                    character = "9",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(9))
                    }
                )
                CalcButton(
                    character = "x",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Operator(Operations.Multiply))
                    }
                )
            }
            //Row 3
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                //Calc event is the calculator operation
                CalcButton(
                    character = "4",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(4))
                    }
                )
                CalcButton(
                    character = "5",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(5))
                    }
                )
                CalcButton(
                    character = "6",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(6))
                    }
                )
                CalcButton(
                    character = "-",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Operator(Operations.subtract))
                    }
                )
            }
            //Row 4
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                //Calc event is the calculator operation
                CalcButton(
                    character = "1",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(1))
                    }
                )
                CalcButton(
                    character = "2",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(2))
                    }
                )
                CalcButton(
                    character = "3",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Number(3))
                    }
                )
                CalcButton(
                    character = "+",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Operator(Operations.Add))
                    }
                )
            }
            //Row 2
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                //Calc event is the calculator operation
                CalcButton(
                    character = "0",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(2f)  //Twice bigger as the normal button
                        .weight(2f),
                    onclick = {
                        onAction(CalcEvent.Number(0))
                    }
                )
                CalcButton(
                    character = ".",
                    modifier = Modifier
                        .background(Color.White)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Decimal)
                    }
                )
                CalcButton(
                    character = "=",
                    modifier = Modifier
                        .background(Color.Cyan)
                        .aspectRatio(1f)  //Twice bigger as the normal button
                        .weight(1f),
                    onclick = {
                        onAction(CalcEvent.Calculate)
                    }
                )
            }
        }
    }
}