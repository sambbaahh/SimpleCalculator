package com.example.simplecalculator.Adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simplecalculator.R;
import com.example.simplecalculator.database.CalculationEntities;

import java.util.List;

/**
 * Historia sivun adapteri
 */
public class CalculatorListAdapter extends RecyclerView.Adapter<CalculatorListAdapter.ViewHolder> {
    /**
     * Tietokannan entiteetit
     */
    public List<CalculationEntities> localDataset;

    /**
     * Konstruktori
     * @param localDataset
     */
    public CalculatorListAdapter(List<CalculationEntities> localDataset) {
        this.localDataset = localDataset;
    }

    /**
     * Päivittää historia sivun, kun poistetaan ja lisätään tietokannasta
     * @param localDataset
     */
    public void update(List<CalculationEntities> localDataset){
        this.localDataset.clear();
        this.localDataset.addAll(localDataset);
        this.notifyDataSetChanged();
    }

    /**
     * Alustus metodi
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.calculation_history_item,
                        parent, false);
        return new ViewHolder(view);
    }

    /**
     * Alustus metodi
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CalculatorListAdapter.ViewHolder holder, int
            position) {
        holder.itemView.setTag(position);
        holder.tvCalculation.setText(localDataset.get(position).calculation);
        holder.tvResult.setText(localDataset.get(position).result);
        holder.tvTimeStamp.setText(localDataset.get(position).timeStamp);
    }

    /**
     * Palauttaa tietokannan koon
     * @return localDataset.size() or 0
     */
    @Override
    public int getItemCount() {
        if (localDataset != null) {
            return localDataset.size();
        }
        return 0;
    }

    /**
     * Sisäinen luokka, jossa etsitään tarvittavat komponentit adapteria varten
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * Laskutoimituksen tulos
         */
        public final TextView tvResult;
        /**
         * Laskutoimituksen kaava
         */
        public final TextView tvCalculation;
        /**
         * Laskun aikaleima
         */
        public final TextView tvTimeStamp;

        /**
         * Alustus metodi
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);

            tvCalculation = (TextView) itemView.findViewById(R.id.tvOperation);
            tvResult = (TextView) itemView.findViewById(R.id.tvResult);
            tvTimeStamp = (TextView) itemView.findViewById(R.id.tvTimeStamp);
        }
    }
}