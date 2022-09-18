package com.example.simplecalculator.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Tietokanta luodaan tässä luokassa
 */
@Database(entities = {CalculationEntities.class}, version = 1)
public abstract class CalculatorDatabase extends RoomDatabase {
    /**
     * Viittaus DAO rajapintaan
     * @return
     */
    public abstract CalculatorDao CalculatorDao();

}
