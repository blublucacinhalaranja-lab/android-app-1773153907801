package com.pacote.app.databinding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.pacote.app.R
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import java.lang.NullPointerException
import java.lang.Override

class ActivityMainBinding(@NonNull val root: View, @NonNull val button0: Button,
                          @NonNull val button1: Button, @NonNull val button2: Button,
                          @NonNull val button3: Button, @NonNull val button4: Button,
                          @NonNull val button5: Button, @NonNull val button6: Button,
                          @NonNull val button7: Button, @NonNull val button8: Button,
                          @NonNull val button9: Button, @NonNull val buttonAdd: Button,
                          @NonNull val buttonClear: Button, @NonNull val buttonDecimal: Button,
                          @NonNull val buttonDivide: Button, @NonNull val buttonEquals: Button,
                          @NonNull val buttonMultiply: Button, @NonNull val buttonSubtract: Button,
                          @NonNull val textViewInput: TextView, @NonNull val textViewResult: TextView) : ViewBinding {

    @NonNull
    override fun getRoot(): View {
        return root
    }

    companion object {
        @NonNull
        fun inflate(@NonNull inflater: LayoutInflater): ActivityMainBinding {
            return inflate(inflater, null, false)
        }

        @NonNull
        fun inflate(@NonNull inflater: LayoutInflater, @Nullable parent: ViewGroup?,
                    attachToParent: Boolean): ActivityMainBinding {
            val root = inflater.inflate(R.layout.activity_main, parent, false)
            if (attachToParent) {
                parent?.addView(root)
            }
            return bind(root)
        }

        @NonNull
        fun bind(@NonNull rootView: View): ActivityMainBinding {
            val button0 = rootView.findViewById<Button>(R.id.button0)
            if (button0 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button0")
            }
            val button1 = rootView.findViewById<Button>(R.id.button1)
            if (button1 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button1")
            }
            val button2 = rootView.findViewById<Button>(R.id.button2)
            if (button2 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button2")
            }
            val button3 = rootView.findViewById<Button>(R.id.button3)
            if (button3 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button3")
            }
            val button4 = rootView.findViewById<Button>(R.id.button4)
            if (button4 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button4")
            }
            val button5 = rootView.findViewById<Button>(R.id.button5)
            if (button5 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button5")
            }
            val button6 = rootView.findViewById<Button>(R.id.button6)
            if (button6 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button6")
            }
            val button7 = rootView.findViewById<Button>(R.id.button7)
            if (button7 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button7")
            }
            val button8 = rootView.findViewById<Button>(R.id.button8)
            if (button8 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button8")
            }
            val button9 = rootView.findViewById<Button>(R.id.button9)
            if (button9 == null) {
                throw NullPointerException("Missing required view with ID: R.id.button9")
            }
            val buttonAdd = rootView.findViewById<Button>(R.id.buttonAdd)
            if (buttonAdd == null) {
                throw NullPointerException("Missing required view with ID: R.id.buttonAdd")
            }
            val buttonClear = rootView.findViewById<Button>(R.id.buttonClear)
            if (buttonClear == null) {
                throw NullPointerException("Missing required view with ID: R.id.buttonClear")
            }
            val buttonDecimal = rootView.findViewById<Button>(R.id.buttonDecimal)
            if (buttonDecimal == null) {
                throw NullPointerException("Missing required view with ID: R.id.buttonDecimal")
            }
            val buttonDivide = rootView.findViewById<Button>(R.id.buttonDivide)
            if (buttonDivide == null) {
                throw NullPointerException("Missing required view with ID: R.id.buttonDivide")
            }
            val buttonEquals = rootView.findViewById<Button>(R.id.buttonEquals)
            if (buttonEquals == null) {
                throw NullPointerException("Missing required view with ID: R.id.buttonEquals")
            }
            val buttonMultiply = rootView.findViewById<Button>(R.id.buttonMultiply)
            if (buttonMultiply == null) {
                throw NullPointerException("Missing required view with ID: R.id.buttonMultiply")
            }
            val buttonSubtract = rootView.findViewById<Button>(R.id.buttonSubtract)
            if (buttonSubtract == null) {
                throw NullPointerException("Missing required view with ID: R.id.buttonSubtract")
            }
            val textViewInput = rootView.findViewById<TextView>(R.id.textViewInput)
            if (textViewInput == null) {
                throw NullPointerException("Missing required view with ID: R.id.textViewInput")
            }
            val textViewResult = rootView.findViewById<TextView>(R.id.textViewResult)
            if (textViewResult == null) {
                throw NullPointerException("Missing required view with ID: R.id.textViewResult")
            }
            return ActivityMainBinding(rootView, button0, button1, button2, button3, button4, button5,
                button6, button7, button8, button9, buttonAdd, buttonClear, buttonDecimal,
                buttonDivide, buttonEquals, buttonMultiply, buttonSubtract, textViewInput, textViewResult)
        }
    }
}