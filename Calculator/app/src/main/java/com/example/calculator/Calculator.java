package com.example.calculator;

import java.math.BigDecimal;

public class Calculator {

    public static String evaluate(String expression) throws Exception {
        String[] tokens = expression.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid expression format.");
        }

        BigDecimal operand1 = new BigDecimal(tokens[0]);
        BigDecimal operand2 = new BigDecimal(tokens[2]);
        BigDecimal result;

        switch (tokens[1]) {
            case "+":
                result = operand1.add(operand2);
                break;
            case "-":
                result = operand1.subtract(operand2);
                break;
            case "*":
                result = operand1.multiply(operand2);
                break;
            case "/":
                if (operand2.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Division by zero.");
                }
                result = operand1.divide(operand2, 10, BigDecimal.ROUND_HALF_UP);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }

        return result.stripTrailingZeros().toPlainString();
    }
}
