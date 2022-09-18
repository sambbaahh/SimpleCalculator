package com.example.simplecalculator.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.simplecalculator.Equals;
import com.example.simplecalculator.R;
import com.example.simplecalculator.database.CalculationEntities;
import com.example.simplecalculator.database.CalculatorDao;
import com.example.simplecalculator.database.CalculatorDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Calculator Fragment, täällä tehdään nappien toiminnallisuudet
 */
public class Calculator extends Fragment implements View.OnClickListener {
    /**
     * Näyttää syötetyn tiedon ja ulostulevan tiedon
     */
    private TextView output;

    /**
     * Tietokanta viittaus
     */
    protected static CalculatorDatabase database;

    /**
     * Tietokannan kysely rajapinta
     */
    private CalculatorDao Dao;


    /**
     * Täyttää tämän fragmentin asettelun
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);

    }

    /**
     * Alustetaan napit asettelun tekemisen jälkeen
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        database = Room.databaseBuilder(
                getActivity().getApplicationContext(),
                CalculatorDatabase.class,
                "database-name").allowMainThreadQueries().build();

        Dao = (CalculatorDao) database.CalculatorDao();

        output = (TextView) getView().findViewById(R.id.tvOutput);

        Button zero = (Button) getView().findViewById(R.id.btnZero);
        zero.setOnClickListener(this);

        Button one = (Button) getView().findViewById(R.id.btnOne);
        one.setOnClickListener(this);

        Button two = (Button) getView().findViewById(R.id.btnTwo);
        two.setOnClickListener(this);

        Button three = (Button) getView().findViewById(R.id.btnThree);
        three.setOnClickListener(this);

        Button four = (Button) getView().findViewById(R.id.btnFour);
        four.setOnClickListener(this);

        Button five = (Button) getView().findViewById(R.id.btnFive);
        five.setOnClickListener(this);

        Button six = (Button) getView().findViewById(R.id.btnSix);
        six.setOnClickListener(this);

        Button seven = (Button) getView().findViewById(R.id.btnSeven);
        seven.setOnClickListener(this);

        Button eight = (Button) getView().findViewById(R.id.btnEight);
        eight.setOnClickListener(this);

        Button nine = (Button) getView().findViewById(R.id.btnNine);
        nine.setOnClickListener(this);

        Button decimal = (Button) getView().findViewById(R.id.btnDecimal);
        decimal.setOnClickListener(this);

        Button equal = (Button) getView().findViewById(R.id.btnEqual);
        equal.setOnClickListener(this);

        Button sum = (Button) getView().findViewById(R.id.btnSum);
        sum.setOnClickListener(this);

        Button difference = (Button) getView().findViewById(R.id.btnDifference);
        difference.setOnClickListener(this);

        Button multiply = (Button) getView().findViewById(R.id.btnMultiply);
        multiply.setOnClickListener(this);

        Button division = (Button) getView().findViewById(R.id.btnDivision);
        division.setOnClickListener(this);

        Button percentage = (Button) getView().findViewById(R.id.btnPercentage);
        percentage.setOnClickListener(this);

        ImageButton erase = (ImageButton) getView().findViewById(R.id.btnErase);
        erase.setOnClickListener(this);

        Button clear = (Button) getView().findViewById(R.id.btnClear);
        clear.setOnClickListener(this);

        ImageButton clearHistory = (ImageButton) getView().findViewById(R.id.btnHistoryClear);
        clearHistory.setOnClickListener(this);


    }


    /**
     * Napin painallus metodi
     * @param view
     */
    @Override
    public void onClick(View view) {
        //I had switch-case but Android Studio suggested to use if-else

        int id = view.getId();

        if (output.getText().length() < 35) {

            if (id == R.id.btnZero) {
                output.setText(output.getText() + "0");
            } else if (id == R.id.btnOne) {
                output.setText(output.getText() + "1");
            } else if (id == R.id.btnTwo) {
                output.setText(output.getText() + "2");
            } else if (id == R.id.btnThree) {
                output.setText(output.getText() + "3");
            } else if (id == R.id.btnFour) {
                output.setText(output.getText() + "4");
            } else if (id == R.id.btnFive) {
                output.setText(output.getText() + "5");
            } else if (id == R.id.btnSix) {
                output.setText(output.getText() + "6");
            } else if (id == R.id.btnSeven) {
                output.setText(output.getText() + "7");
            } else if (id == R.id.btnEight) {
                output.setText(output.getText() + "8");
            } else if (id == R.id.btnNine) {
                output.setText(output.getText() + "9");
            } else if (id == R.id.btnDecimal) {
                if (CheckChar()) {
                    output.setText(output.getText() + getResources().getString(R.string.Decimal));
                }
            } else if (id == R.id.btnSum) {
                if (CheckChar()) {
                    output.setText(output.getText() + "+");
                }
            } else if (id == R.id.btnDifference) {
                if (CheckChar()) {
                    output.setText(output.getText() + "-");
                }
            } else if (id == R.id.btnMultiply) {
                if (CheckChar()) {
                    output.setText(output.getText() + "×");
                }
            } else if (id == R.id.btnDivision) {
                if (CheckChar()) {
                    output.setText(output.getText() + "÷");
                }
            } else if (id == R.id.btnPercentage) {
                if (CheckPercentage()) {
                    output.setText(output.getText() + "%");
                }
            }
        }


        if (id == R.id.btnErase) {
            if(output.getText().length() != 0) {
                String display = output.getText().toString();
                display = display.substring(0, display.length() - 1);
                output.setText(display);
            }
        }

        else if (id == R.id.btnEqual) {

            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM HH:mm");
            Equals equals = new Equals(output.getText().toString(), simpleDateFormat.format(calendar.getTime()));

            equals.isEqualTo();

            InitiateCalculation(equals.operation, equals.result, equals.operationTime);
            History.calculatorListAdapter.update(database.CalculatorDao().getAllCalculations());

            output.setText(null);
            output.setText(equals.result);
        }

        else if (id == R.id.btnClear) {
            output.setText(null);
        }

        else if (id == R.id.btnHistoryClear) {
            Dao.deleteAll();
            History.calculatorListAdapter.update(database.CalculatorDao().getAllCalculations());


        }
    }

    /**
     * Tallentaa laskukaavan, vastauksen ja aikaleiman tietokantaan
     * @param calculation
     * @param result
     * @param operationTime
     */
    protected void InitiateCalculation(String calculation, String result, String operationTime){
        CalculationEntities saveCalculation = new CalculationEntities();
        saveCalculation.calculation = calculation;
        saveCalculation.result = "=" + result;
        saveCalculation.timeStamp = operationTime;

        Dao.insertAll(saveCalculation);
    }


    /**
     * @return boolean
     * Tarkistaa, ettei tule peräkkäin laskutoimitus merkkejä
     */
    public boolean CheckChar(){
        if (output.getText().length() == 0) {
            return false;
        }
        char calcalatorLastChar = output.getText().toString().charAt(output.getText().length() - 1);
        if (calcalatorLastChar == '.' || calcalatorLastChar == '+' || calcalatorLastChar == '-' ||
                calcalatorLastChar == '×' || calcalatorLastChar == '÷') {
                return false;
        }
        return true;
    }


    /**
     * Tarkistaa, ettei voi laittaa useampaa prosenttimerkkiä peräkkäin
     * @return boolean
     */

    public boolean CheckPercentage(){
        if (output.getText().length() == 0) {
            return false;
        }
        char calcalatorLastChar = output.getText().toString().charAt(output.getText().length() - 1);
        if (calcalatorLastChar == '%') {
            return false;

        }
        return true;
    }
}