package com.example.calculator

sealed class CalcEvent{
    data class Number(val number: Int):CalcEvent()
    object Clear: CalcEvent() //clear the screen
    object Delete: CalcEvent()  //delete the last number
    object Decimal: CalcEvent() //decimal point
    object Calculate: CalcEvent()  //calculate the result
    data class Operator(val operations: Operations):CalcEvent() //the operators
}
