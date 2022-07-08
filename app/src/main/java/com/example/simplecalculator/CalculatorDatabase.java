package com.example.simplecalculator;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CalculationEntities.class}, version = 1)
public abstract class CalculatorDatabase extends RoomDatabase {
    public abstract CalculatorDao CalculatorDao();

}
