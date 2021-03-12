package com.example.ppeinnov;

import com.google.gson.annotations.SerializedName;

public class Api {
    @SerializedName("nom")
    private String nom;


    public String getNom(){

        return nom;
    }
}
