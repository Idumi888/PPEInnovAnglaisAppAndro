package com.example.ppeinnov;

import com.google.gson.annotations.SerializedName;

public class Hydra {
    @SerializedName("hydra:member")
     Api[] hydra;

    public Api[] getTab(){

        return hydra;
    }
}
