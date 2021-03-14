package com.example.ppeinnov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        getSupportActionBar().hide();

    }
        public void navigationActivityTheme(View v) {

            Intent listeTheme = new Intent(this, ThemeActivity.class);

            startActivity(listeTheme);
            }

        public void navigationActivityUser(View w) {

        Intent listeUser = new Intent(this, UserActivity.class);

        startActivity(listeUser);
    }

    public void navigationActivityVoca(View z) {

        Intent listeUser = new Intent(this, VocabulaireActivity.class);

        startActivity(listeUser);
    }


}