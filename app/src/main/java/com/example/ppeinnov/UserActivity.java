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

public class UserActivity extends AppCompatActivity {
    private RecyclerView listeUserRecyclerView;
    private RecyclerView.Adapter userListeAdapter;
    private RecyclerView.LayoutManager userListeLayoutManager;
    User[] listOfUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        listeUserRecyclerView = findViewById(R.id.listeThemeRecyclerView);

        userListeLayoutManager = new LinearLayoutManager(this);
        listeUserRecyclerView.setLayoutManager(userListeLayoutManager);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://serveur1.arras-sio.com/symfony4-4066/PpeInov/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);
        Call<Hydra> callGetTodoById = webServicesInterface.getAllUsers();
        callGetTodoById.enqueue(new Callback<Hydra>() {
            @Override
            public void onResponse(Call<Hydra> call, Response<Hydra> response) {
                Hydra hydra = response.body();
                int nombre =hydra.getTab().length;
                listOfUser = new User[nombre];
                for (int utilisateur = 0; utilisateur < nombre; utilisateur++){
                    System.out.println("");


                    System.out.print(hydra.getTab()[utilisateur].getNom());
                    System.out.print(hydra.getTab()[utilisateur].getEntreprise());
                    listOfUser[utilisateur] = new User(hydra.getTab()[utilisateur].getNom(),hydra.getTab()[utilisateur].getPrenom(),hydra.getTab()[utilisateur].getEntreprise()  );

                    System.out.println( );

                }
                userListeAdapter = new UserListeAdapter(listOfUser);
                listeUserRecyclerView.setAdapter(userListeAdapter);

            }
            @Override
            public void onFailure(Call<Hydra> call, Throwable t) {
                System.out.println("FAIL");
            }
        });
    }
}

