package com.example.simplecalculator.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * Rajapinta tietokanta kyselyitä varten
 */
@Dao
public interface CalculatorDao {

        /**
         * Lisätään laskuja tietokantaan
         * @param calculations
         */
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        void insertAll(CalculationEntities... calculations);

        /**
         * Haetaan kaikki laskut tietokannasta
         * @return
         */
        @Query("SELECT * FROM CalculationEntities")
        List<CalculationEntities> getAllCalculations();

        /**
         * Poistetaan tietokannasta kaikki laskut
         */
        @Query("DELETE FROM CalculationEntities")
        void deleteAll();

}
