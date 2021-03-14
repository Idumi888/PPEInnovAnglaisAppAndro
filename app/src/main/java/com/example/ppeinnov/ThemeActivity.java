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

public class ThemeActivity extends AppCompatActivity {
    private RecyclerView listeThemeRecyclerView;
    private RecyclerView.Adapter themeListeAdapter;
    private RecyclerView.LayoutManager themeListeLayoutManager;
    Theme[] listOfTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listeThemeRecyclerView = findViewById(R.id.listeThemeRecyclerView);

        themeListeLayoutManager = new LinearLayoutManager(this);
        listeThemeRecyclerView.setLayoutManager(themeListeLayoutManager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://serveur1.arras-sio.com/symfony4-4066/PpeInov/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Hydra> callGetTodoById = webServicesInterface.getAllThemes();
        callGetTodoById.enqueue(new Callback<Hydra>() {
            @Override
            public void onResponse(Call<Hydra> call, Response<Hydra> response) {
                Hydra hydra = response.body();
                int nombre =hydra.getTab().length;
                listOfTheme = new Theme[nombre];
                for (int drink = 0; drink < nombre; drink++){
                    System.out.println("");

                    System.out.print(hydra.getTab()[drink].getNom());
                    listOfTheme[drink] = new Theme(hydra.getTab()[drink].getLibelle());

                }
                themeListeAdapter = new ThemeListeAdapter(listOfTheme);
                listeThemeRecyclerView.setAdapter(themeListeAdapter);

            }
            @Override
            public void onFailure(Call<Hydra> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }
}

