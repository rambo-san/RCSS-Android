package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String currentInput = "";
    private double operand1 = Double.NaN;
    private double operand2 = Double.NaN;
    private char currentOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
    }

    public void onDigitClick(View view) {
        String digit = ((TextView) view).getText().toString();
        currentInput += digit;
        updateDisplay(currentInput);
    }

    public void onOperatorClick(View view) {
        if (!Double.isNaN(operand1)) {
            // If an operator is already set, perform the operation first
            if (!currentInput.isEmpty()) {
                operand2 = Double.parseDouble(currentInput);
                performOperation();
            }
        } else {
            operand1 = Double.parseDouble(currentInput);
        }
        currentOperator = ((TextView) view).getText().charAt(0);
        currentInput = "";
    }

    public void onClearClick(View view) {
        clearCalculator();
    }

    public void onPlusMinusClick(View view) {
        if (!currentInput.isEmpty()) {
            double value = Double.parseDouble(currentInput);
            value *= -1;
            currentInput = Double.toString(value);
            updateDisplay(currentInput);
        }
    }

    public void onPercentClick(View view) {
        if (!currentInput.isEmpty()) {
            double value = Double.parseDouble(currentInput);
            value /= 100;
            currentInput = Double.toString(value);
            updateDisplay(currentInput);
        }
    }

    public void onDotClick(View view) {
        if (!currentInput.contains(".")) {
            currentInput += ".";
            updateDisplay(currentInput);
        }
    }

    public void onEqualsClick(View view) {
        if (!currentInput.isEmpty() && !Double.isNaN(operand1) && currentOperator != '\u0000') {
            operand2 = Double.parseDouble(currentInput);
            performOperation();
            currentOperator = '\u0000';
        }
    }

    private void performOperation() {
        double result = Double.NaN;
        switch (currentOperator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    // Handle division by zero
                    clearCalculator();
                    updateDisplay("Error");
                    return;
                }
                break;
        }
        operand1 = result;
        currentInput = Double.toString(result);
        updateDisplay(currentInput);
    }

    private void clearCalculator() {
        currentInput = "";
        operand1 = Double.NaN;
        operand2 = Double.NaN;
        currentOperator = '\u0000';
        updateDisplay("0");
    }

    private void updateDisplay(String text) {
        tvDisplay.setText(text);
    }
}
