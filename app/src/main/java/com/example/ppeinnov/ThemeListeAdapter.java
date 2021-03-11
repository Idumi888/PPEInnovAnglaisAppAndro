package com.example.ppeinnov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ThemeListeAdapter extends RecyclerView.Adapter<ThemeCell>{
    private Theme[] dataSource;


    public ThemeListeAdapter(Theme[] dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ThemeCell onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.theme_liste_cell, parent,
                        false);
        ThemeCell themeCell = new ThemeCell(view);
        return themeCell;
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeCell holder, int position) {
        holder.themeNom.setText(dataSource[position].getNom());
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }
}
