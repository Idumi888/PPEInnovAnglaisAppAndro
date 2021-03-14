

package com.example.ppeinnov;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

public class VocabulaireListeAdapter extends RecyclerView.Adapter<VocabulaireCell>{
    private Vocabulaire[] dataSource;


    public VocabulaireListeAdapter(Vocabulaire[] dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public VocabulaireCell onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.vocabulaire_liste_cell, parent,
                        false);
        VocabulaireCell vocabulaireCell = new VocabulaireCell(view);
        return vocabulaireCell;
    }

    @Override
    public void onBindViewHolder(@NonNull VocabulaireCell holder, int position) {
        holder.vocabulaireLibelle.setText(dataSource[position].getLibelle());
        holder.vocabulaireTraduction.setText(dataSource[position].getTraduction());
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }
}
