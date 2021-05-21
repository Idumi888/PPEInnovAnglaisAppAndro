package com.example.ppeinnov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserListeAdapter extends RecyclerView.Adapter<UserCell>{
    private User[] dataSource;


    public UserListeAdapter(User[] dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public UserCell onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.user_liste_cell, parent,
                        false);
        UserCell userCell = new UserCell(view);
        return userCell;
    }

    @Override
    public void onBindViewHolder(@NonNull UserCell holder, int position) {
        holder.userNom.setText(dataSource[position].getNom());
        holder.userPrenom.setText(dataSource[position].getPrenom());
        holder.userEntreprise.setText(dataSource[position].getEntreprise());
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }
}
