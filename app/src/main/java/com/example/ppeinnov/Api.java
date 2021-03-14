package com.example.ppeinnov;

import com.google.gson.annotations.SerializedName;

public class Api {
    @SerializedName("libelle")
    private String libelle;

    @SerializedName("nom")
    private String nom;

    @SerializedName("id")
    private int id;


    @SerializedName("libelleEn")
    private String traduction;


    @SerializedName("prenom")
    private String prenom;

    public int getId(){

        return id;
    }

    public String getNom(){

        return nom;
    }
    public String getLibelle(){

        return libelle;
    }

    public String getTraduction(){

        return traduction;
    }
    public String getPrenom(){

        return prenom;
    }
}
