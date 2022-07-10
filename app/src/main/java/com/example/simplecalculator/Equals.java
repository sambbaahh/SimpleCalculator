package com.example.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.mariuszgromada.math.mxparser.*;

public class Equals extends Activity {
    String result;
    String operation;
    String operationTime;




    public Equals(String operation, String operationTime) {
        this.operation = operation;
        this.operationTime = operationTime;
    }

    public void isEqualTo(){

        operation = operation.replaceAll("÷", "/");
        operation = operation.replaceAll("×", "*");

        Expression expression = new Expression(operation);
        result = String.valueOf(expression.calculate());

        //poista .0 jos ainoastaan se
        //result = result.replace(".0","");
    }

}
