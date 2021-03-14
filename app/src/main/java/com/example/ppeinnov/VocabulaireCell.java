

package com.example.ppeinnov;

        import android.view.View;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

public class VocabulaireCell extends RecyclerView.ViewHolder {
    public TextView vocabulaireLibelle;
    public TextView vocabulaireTraduction;

    public VocabulaireCell(@NonNull View itemView) {
        super(itemView);
        vocabulaireLibelle = itemView.findViewById(R.id.vocabulaireLibelle);
        vocabulaireTraduction = itemView.findViewById(R.id.vocabulaireTraduction);
    }
}

