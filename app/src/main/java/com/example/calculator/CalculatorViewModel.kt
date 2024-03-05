package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    var state by mutableStateOf(CalcState())
        private set
    //The state cannot be changed from the outside but can still be accessed and be read


    fun onAction(action: CalcEvent) {
        when (action) {
            is CalcEvent.Number -> enterNumber(action.number)
            is CalcEvent.Decimal -> enterDecimal()
            is CalcEvent.Clear -> state = CalcState()
            is CalcEvent.Operator -> enterOperation(action.operations)
            is CalcEvent.Calculate -> performCalculation()
            is CalcEvent.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }

    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number1.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is Operations.Add -> number1 + number2
                is Operations.subtract -> number1 - number2
                is Operations.Multiply -> number1 * number2
                is Operations.Divide -> number1 / number2
                null -> return
                else -> {
                    return
                }
            }
            //Completion
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            ) //The result is converted to a string and the first 15 characters are taken
        }

    }

    private fun enterOperation(operations: Operations) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operations)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".")
            && state.number2.isNotBlank()
        ) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_lENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_lENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_lENGTH = 8
    }
}