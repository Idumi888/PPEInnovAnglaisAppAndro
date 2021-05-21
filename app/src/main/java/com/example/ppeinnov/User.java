package com.example.ppeinnov;

public class User {

        private String nom;
        private String prenom;
        private String entreprise;

        public User(String nom, String prenom, String entreprise) {
            this.nom = nom;
            this.prenom = prenom;
            this.entreprise = entreprise;

        }

        public String getNom() {
            return nom;
        }
        public String getPrenom() {
        return prenom;
    }
        public String getEntreprise() { return entreprise;
    }
    }

