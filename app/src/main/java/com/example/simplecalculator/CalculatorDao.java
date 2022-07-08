package com.example.simplecalculator;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface CalculatorDao {

        @Query("SELECT * FROM CalculationEntities WHERE calculation LIKE :name LIMIT 1")
        CalculationEntities findByName(String name);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(CalculationEntities... calculations);

        @Query("SELECT * FROM CalculationEntities")
        CalculationEntities[] getAllCalculations();

        @Query("DELETE FROM CalculationEntities")
        void deleteAll();

}
