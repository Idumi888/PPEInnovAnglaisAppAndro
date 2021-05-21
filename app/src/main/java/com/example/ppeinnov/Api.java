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

    @SerializedName("fichier")
    private String[] fichier;

    @SerializedName("entreprises")
    private String entreprise;

    @SerializedName("entreprises")
    private int numEntreprise;


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
    public String[] getFichier(){

        return fichier;
    }
    public String getEntreprise(){

        return entreprise;
    }
    
}
