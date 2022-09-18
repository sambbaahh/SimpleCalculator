package com.example.simplecalculator;

import android.app.Activity;
import org.mariuszgromada.math.mxparser.*;

/**
 * Luokka, jossa lasketaan laskutoimitusten tulos
 */
public class Equals extends Activity {
    /**
     * Laskut lasketaan expressionin avulla
     */
    Expression expression;
    /**
     * laskun tulos
     */
    public String result;
    /**
     * Laskukaava
     */
    public String operation;
    /**
     * Laskun aikaleima
     */
    public String operationTime;

    /**
     * Konstruktori
     * @param operation
     * @param operationTime
     */
    public Equals(String operation, String operationTime) {
        this.operation = operation;
        this.operationTime = operationTime;
    }

    /**
     * Metodi, jolla lasketaan laskun tulos
     */
    public void isEqualTo(){

        operation = operation.replaceAll("÷", "/");
        operation = operation.replaceAll("×", "*");

        expression = new Expression(operation);
        result = String.valueOf(expression.calculate());


    }

}
