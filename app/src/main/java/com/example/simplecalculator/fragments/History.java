package com.example.simplecalculator.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simplecalculator.Adapters.CalculatorListAdapter;
import com.example.simplecalculator.R;

/**
 * Historia fragmentin luokka
 */
public class History extends Fragment {
    /**
     * viittaus adapteriin, jolla haetaan historia sivulle laskut
     */
    public static CalculatorListAdapter calculatorListAdapter;

    /**
     * Alustus metodi
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    /**
     * Alustus metodi, jossa alustetaan adapteri ja recyclerview
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        calculatorListAdapter = new CalculatorListAdapter(Calculator.database.
                CalculatorDao().getAllCalculations());
        RecyclerView rvHistory = getView().findViewById(R.id.rvCalculationHistory);
        rvHistory.setAdapter(calculatorListAdapter);
        rvHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        super.onViewCreated(view, savedInstanceState);
    }
}