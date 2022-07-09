package com.example.simplecalculator;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CalculationEntities {

    @PrimaryKey(autoGenerate = true)
    public int CalculationID;

    @ColumnInfo(name="calculation")
    public String calculation;

    @ColumnInfo(name="result")
    public String result;

    @ColumnInfo(name="timeStamp")
    public String timeStamp;

}
