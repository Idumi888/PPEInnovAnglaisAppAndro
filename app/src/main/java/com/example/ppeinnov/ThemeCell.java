package com.example.ppeinnov;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ThemeCell extends RecyclerView.ViewHolder {
    public TextView themeNom;

    public ThemeCell(@NonNull View itemView) {
        super(itemView);
        themeNom = itemView.findViewById(R.id.themeNom);
    }
}
