package com.example.simplecalculator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CalculatorListAdapter extends RecyclerView.Adapter<CalculatorListAdapter.ViewHolder> {

    public List<CalculationEntities> localDataset;

    public CalculatorListAdapter() {
        ReloadData();

    }

    public void ReloadData(){
        localDataset = Calculator.database.CalculatorDao().getAllCalculations();
        CalculatorListAdapter.this.notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.calculation_history_item,
                        parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CalculatorListAdapter.ViewHolder holder, int
            position) {
        holder.itemView.setTag(position);

        holder.tvCalculation.setText(localDataset.get(position).calculation);
        holder.tvResult.setText(localDataset.get(position).result);
        holder.tvTimeStamp.setText(localDataset.get(position).timeStamp);
    }


    @Override
    public int getItemCount() {
        return localDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tvResult;
        public final TextView tvCalculation;
        public final TextView tvTimeStamp;


        public ViewHolder(View itemView) {
            super(itemView);

            tvCalculation = (TextView) itemView.findViewById(R.id.tvOperation);
            tvResult = (TextView) itemView.findViewById(R.id.tvResult);
            tvTimeStamp = (TextView) itemView.findViewById(R.id.tvTimeStamp);
        }
    }
}