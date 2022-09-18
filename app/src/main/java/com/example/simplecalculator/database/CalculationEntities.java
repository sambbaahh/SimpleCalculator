package com.example.simplecalculator.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Tietokantaan luodaan entiteetit tässä luokassa
 */
@Entity
public class CalculationEntities {

    /**
     * Laskun ID
     */
    @PrimaryKey(autoGenerate = true)
    public int CalculationID;

    /**
     * Laskun kaava
     */
    @ColumnInfo(name="calculation")
    public String calculation;

    /**
     * Laskun lopputulos
     */
    @ColumnInfo(name="result")
    public String result;

    /**
     * Laskun aikaleima
     */
    @ColumnInfo(name="timeStamp")
    public String timeStamp;

}
