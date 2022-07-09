package com.example.simplecalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class SaveCalculation extends AppCompatActivity {
    /*
    public static CalculatorDatabase database;
    public CalculatorDao Dao;

    public SaveCalculation() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = Room.databaseBuilder(
                getApplicationContext(),
                CalculatorDatabase.class,
                "database-name").allowMainThreadQueries().build();
        Dao = (CalculatorDao) database.CalculatorDao();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_history);

    }

    protected void InitiateCalculation(String calculation, String result, String operationTime){
        CalculationEntities saveCalculation = new CalculationEntities();
        saveCalculation.calculation = calculation;
        saveCalculation.result = result;
        saveCalculation.timeStamp = operationTime;
        //saveCalculation.CalculationID = 1;

        Dao.insertAll(saveCalculation);
    }


     */

}