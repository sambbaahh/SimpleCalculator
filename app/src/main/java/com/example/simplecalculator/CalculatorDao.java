package com.example.simplecalculator;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CalculatorDao {

        @Query("SELECT * FROM CalculationEntities WHERE calculation LIKE :name LIMIT 1")
        CalculationEntities findByName(String name);

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(CalculationEntities... calculations);

        @Query("SELECT * FROM CalculationEntities")
        List<CalculationEntities> getAllCalculations();

        @Query("DELETE FROM CalculationEntities")
        void deleteAll();

}
