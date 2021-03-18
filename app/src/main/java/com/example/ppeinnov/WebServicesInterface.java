package com.example.ppeinnov;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServicesInterface {

    @GET("users?page=1")
    Call<Hydra> getAllUsers();

    @GET("themes?page=1")
    Call<Hydra> getAllThemes();

    @GET("vocabulaires?page=1")
    Call<Hydra> getAllVocabulaires();
}
