package com.example.ppeinnov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://serveur1.arras-sio.com/symfony4-4066/PpeInov/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Api> callGetTodoById = webServicesInterface.getTodoByID();
        callGetTodoById.enqueue(new Callback<Api>() {
            @Override
            public void onResponse(Call<Api> call, Response<Api> response) {
                System.out.println(response.body().getNom());
            }
            @Override
            public void onFailure(Call<Api> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }
}