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


public class CalculatorListAdapter extends RecyclerView.Adapter<CalculatorListAdapter.ViewHolder> {

    CalculationEntities[] localDataset;

    public CalculatorListAdapter() {
    }

    public CalculatorListAdapter(CalculationEntities[] dataset) {
        localDataset = dataset;

    }

    /*
    public void CalculatorList(CalculationEntities[] dataset) {
        localDataset = null;
        localDataset = dataset;
        notifyDataSetChanged();

    }

     */

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calculation_history_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CalculatorListAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(position);

        holder.tvCalculation.setText(localDataset[position].calculation);
        holder.tvResult.setText(localDataset[position].result);
        holder.tvTimeStamp.setText(localDataset[position].timeStamp);
    }

    /*
    public void Update(){

        notifyDataSetChanged();
    }

     */

    @Override
    public int getItemCount() {
        return localDataset.length;
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
