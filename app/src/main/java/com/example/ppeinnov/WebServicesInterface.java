package com.example.ppeinnov;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServicesInterface {
    @GET("users/15")
    Call<Api> getTodoByID();
}
