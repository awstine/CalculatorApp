package com.example.calculator

sealed class Operations (val character: String){
    object Add: Operations("+")
    object subtract: Operations("-")
    object Multiply: Operations("x")
    object Divide: Operations("/")
}
