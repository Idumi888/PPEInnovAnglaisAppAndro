

package com.example.ppeinnov;

        import android.view.View;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

public class UserCell extends RecyclerView.ViewHolder {
    public TextView userNom;
    public TextView userPrenom;
    public TextView userEntreprise;

    public UserCell(@NonNull View itemView) {
        super(itemView);
        userNom = itemView.findViewById(R.id.userNom);
        userPrenom = itemView.findViewById(R.id.userPrenom);
        userEntreprise = itemView.findViewById(R.id.userEntreprise);
    }
}

