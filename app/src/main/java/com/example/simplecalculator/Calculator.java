package com.example.simplecalculator;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Calculator extends Fragment implements View.OnClickListener {
    TextView output;

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button decimal;
    Button equal;
    Button sum;
    Button difference;
    Button multiply;
    Button division;
    Button percentage;
    ImageButton erase;
    Button clear;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        output = (TextView) getView().findViewById(R.id.output);

        zero = (Button) getView().findViewById(R.id.btnZero);
        zero.setOnClickListener(this);

        one = (Button) getView().findViewById(R.id.btnOne);
        one.setOnClickListener(this);

        two = (Button) getView().findViewById(R.id.btnTwo);
        two.setOnClickListener(this);

        three = (Button) getView().findViewById(R.id.btnThree);
        three.setOnClickListener(this);

        four = (Button) getView().findViewById(R.id.btnFour);
        four.setOnClickListener(this);

        five = (Button) getView().findViewById(R.id.btnFive);
        five.setOnClickListener(this);

        six = (Button) getView().findViewById(R.id.btnSix);
        six.setOnClickListener(this);

        seven = (Button) getView().findViewById(R.id.btnSeven);
        seven.setOnClickListener(this);

        eight = (Button) getView().findViewById(R.id.btnEight);
        eight.setOnClickListener(this);

        nine = (Button) getView().findViewById(R.id.btnNine);
        nine.setOnClickListener(this);

        decimal = (Button) getView().findViewById(R.id.btnDecimal);
        decimal.setOnClickListener(this);

        equal = (Button) getView().findViewById(R.id.btnEqual);
        equal.setOnClickListener(this);

        sum = (Button) getView().findViewById(R.id.btnSum);
        sum.setOnClickListener(this);

        difference = (Button) getView().findViewById(R.id.btnDifference);
        difference.setOnClickListener(this);

        multiply = (Button) getView().findViewById(R.id.btnMultiply);
        multiply.setOnClickListener(this);

        division = (Button) getView().findViewById(R.id.btnDivision);
        division.setOnClickListener(this);

        percentage = (Button) getView().findViewById(R.id.btnPercentage);
        percentage.setOnClickListener(this);

        erase = (ImageButton) getView().findViewById(R.id.btnErase);
        erase.setOnClickListener(this);

        clear = (Button) getView().findViewById(R.id.btnClear);
        clear.setOnClickListener(this);
    }





    @Override
    public void onClick(View v) {
        //I had switch-case
        int id = v.getId();

        if (id == R.id.btnZero) {
            output.setText(output.getText() + "0");
        }

        if (id == R.id.btnOne) {
            output.setText(output.getText() + "1");
        }

        else if (id == R.id.btnTwo) {
            output.setText(output.getText() + "2");
        }

        else if (id == R.id.btnThree) {
            output.setText(output.getText() + "3");
        }

        else if (id == R.id.btnFour) {
            output.setText(output.getText() + "4");
        }

        else if (id == R.id.btnFive) {
            output.setText(output.getText() + "5");
        }

        else if (id == R.id.btnSix) {
            output.setText(output.getText() + "6");
        }

        else if (id == R.id.btnSeven) {
            output.setText(output.getText() + "7");
        }

        else if (id == R.id.btnEight) {
            output.setText(output.getText() + "8");
        }

        else if (id == R.id.btnNine) {
            output.setText(output.getText() + "9");
        }

        else if (id == R.id.btnDecimal) {
            output.setText(output.getText() + getResources().getString(R.string.Decimal));
        }

        else if (id == R.id.btnEqual) {

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM HH:mm");
            Equals equals = new Equals(output.getText().toString(), simpleDateFormat.format(calendar.getTime()));

            equals.isEqualTo();

            SaveCalculation saveCalculation = new SaveCalculation();

            saveCalculation.InitiateCalculation(equals.operation,equals.result,equals.operationTime);

            output.setText(null);
            output.setText(equals.result);
        }

        else if (id == R.id.btnSum) {
            output.setText(output.getText() + "+");
        }

        else if (id == R.id.btnDifference) {
            output.setText(output.getText() + "-");
        }

        else if (id == R.id.btnMultiply) {
            output.setText(output.getText() + "×");
        }

        else if (id == R.id.btnDivision) {
            output.setText(output.getText() + "÷");
        }

        else if (id == R.id.btnPercentage) {

            output.setText(output.getText() + "%");
        }

        else if (id == R.id.btnErase) {
            if(output.getText().length() != 0) {
                String display = output.getText().toString();
                display = display.substring(0, display.length() - 1);
                output.setText(display);
            }
        }

        else if (id == R.id.btnClear) {
            output.setText(null);
        }

    }
}