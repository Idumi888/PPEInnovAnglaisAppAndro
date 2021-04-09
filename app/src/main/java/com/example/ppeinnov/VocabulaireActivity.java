

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

public class VocabulaireActivity extends AppCompatActivity {
    private RecyclerView listeVocabulaireRecyclerView;
    private RecyclerView.Adapter vocabulaireListeAdapter;
    private RecyclerView.LayoutManager vocabulaireListeLayoutManager;
    Vocabulaire[] listOfVocabulaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        listeVocabulaireRecyclerView = findViewById(R.id.listeThemeRecyclerView);

        vocabulaireListeLayoutManager = new LinearLayoutManager(this);
        listeVocabulaireRecyclerView.setLayoutManager(vocabulaireListeLayoutManager);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://serveur1.arras-sio.com/symfony4-4066/PpeInov/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Hydra> callGetTodoById = webServicesInterface.getAllVocabulaires();
        callGetTodoById.enqueue(new Callback<Hydra>() {
            @Override
            public void onResponse(Call<Hydra> call, Response<Hydra> response) {
                Hydra hydra = response.body();
                int nombre =hydra.getTab().length;
                listOfVocabulaire = new Vocabulaire[nombre];
                for (int voca = 0; voca < nombre; voca++){

                    System.out.print(hydra.getTab()[voca].getNom());
                    listOfVocabulaire[voca] = new Vocabulaire(hydra.getTab()[voca].getLibelle(),hydra.getTab()[voca].getTraduction() );

                }
                vocabulaireListeAdapter = new VocabulaireListeAdapter(listOfVocabulaire);
                listeVocabulaireRecyclerView.setAdapter(vocabulaireListeAdapter);

            }
            @Override
            public void onFailure(Call<Hydra> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }
}

