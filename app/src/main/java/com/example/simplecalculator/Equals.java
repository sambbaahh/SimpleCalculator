package com.example.simplecalculator;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.mariuszgromada.math.mxparser.*;

public class Equals {
    String result;

    String operation;
    String operationTime;

    public Equals(String operation, String operationTime) {
        this.operation = operation;
        this.operationTime = operationTime;
    }

    public void isEqualTo(){
        operation.replaceAll("÷", "/");
        operation.replaceAll("×", "*");

        Expression expression = new Expression(operation);
        result = String.valueOf(expression.calculate());
        System.out.println(result);


    }



}
