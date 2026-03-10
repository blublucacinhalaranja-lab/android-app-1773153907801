package com.pacote.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pacote.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentInput: String = ""
    private var lastResult: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (BanCalculatorApp.isBanned(this)) {
            Toast.makeText(this, "Você foi banido permanentemente da calculadora.", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.button0.setOnClickListener { appendToInput("0") }
        binding.button1.setOnClickListener { appendToInput("1") }
        binding.button2.setOnClickListener { appendToInput("2") }
        binding.button3.setOnClickListener { appendToInput("3") }
        binding.button4.setOnClickListener { appendToInput("4") }
        binding.button5.setOnClickListener { appendToInput("5") }
        binding.button6.setOnClickListener { appendToInput("6") }
        binding.button7.setOnClickListener { appendToInput("7") }
        binding.button8.setOnClickListener { appendToInput("8") }
        binding.button9.setOnClickListener { appendToInput("9") }

        binding.buttonAdd.setOnClickListener { appendToInput("+") }
        binding.buttonSubtract.setOnClickListener { appendToInput("-") }
        binding.buttonMultiply.setOnClickListener { appendToInput("*") }
        binding.buttonDivide.setOnClickListener { appendToInput("/") }
        binding.buttonDecimal.setOnClickListener { appendToInput(".") }

        binding.buttonClear.setOnClickListener { clearInput() }
        binding.buttonEquals.setOnClickListener { calculateResult() }
    }

    private fun appendToInput(value: String) {
        currentInput += value
        binding.textViewInput.text = currentInput
    }

    private fun clearInput() {
        currentInput = ""
        binding.textViewInput.text = ""
        binding.textViewResult.text = ""
    }

    private fun calculateResult() {
        try {
            // Simple check for "trivial" calculations
            if (currentInput == "2+2" || currentInput == "2+1") {
                BanCalculatorApp.setBanned(this, true)
                Toast.makeText(this, "Você foi banido permanentemente da calculadora.", Toast.LENGTH_LONG).show()
                finish()
                return
            }

            val expression = currentInput
            val result = evaluateExpression(expression)
            lastResult = result

            binding.textViewResult.text = result.toString()
        } catch (e: Exception) {
            binding.textViewResult.text = "Error"
            e.printStackTrace()
        }
    }

    // Simple expression evaluator (for demonstration purposes)
    private fun evaluateExpression(expression: String): Double {
        return try {
            val result = eval(expression)
            result.toDouble()
        } catch (e: Exception) {
            throw IllegalArgumentException("Invalid expression")
        }
    }

    // Incredibly naive evaluator (don't use in production!)
    private fun eval(str: String): Int {
        return object : Any() {
            var pos = -1
            var ch: Char = ' '

            fun nextChar() {
                ch = if ((++pos < str.length)) str[pos] else (-1).toChar()
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' ') nextChar()
                if (ch.code == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Int {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw Exception("Unexpected: " + ch)
                return x
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            fun parseExpression(): Int {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.code)) x += parseTerm() // addition
                    else if (eat('-'.code)) x -= parseTerm() // subtraction
                    else return x
                }
            }

            fun parseTerm(): Int {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.code)) x *= parseFactor() // multiplication
                    else if (eat('/'.code)) x /= parseFactor() // division
                    else return x
                }
            }

            fun parseFactor(): Int {
                if (eat('+'.code)) return parseFactor() // unary plus
                if (eat('-'.code)) return -parseFactor() // unary minus
                var x: Int
                val startPos = pos
                if (eat('('.code)) { // parentheses
                    x = parseExpression()
                    eat(')'.code)
                } else if ((ch >= '0') && (ch <= '9')) { // numbers
                    while ((ch >= '0') && (ch <= '9')) nextChar()
                    x = str.substring(startPos, pos).toInt()
                } else {
                    throw Exception("Unexpected: " + ch)
                }
                return x
            }
        }.parse()
    }
}