package com.example.ppeinnov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listeThemeRecyclerView;
    private RecyclerView.Adapter themeListeAdapter;
    private RecyclerView.LayoutManager themeListeLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listeThemeRecyclerView = findViewById(R.id.listeThemeRecyclerView);

        themeListeLayoutManager = new LinearLayoutManager(this);
        listeThemeRecyclerView.setLayoutManager(themeListeLayoutManager);

        Theme[] listOfUsers = {new Theme("Guillaume"), new Theme("Guillaume"), new Theme("Julien"), new Theme("Guillaume"),  new Theme("Guillaume"), new Theme("Guillaume")};

        themeListeAdapter = new ThemeListeAdapter(listOfUsers);
        listeThemeRecyclerView.setAdapter(themeListeAdapter);

    }
}