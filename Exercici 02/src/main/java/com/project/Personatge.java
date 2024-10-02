package com.project;

public class Personatge {
    private String nom;
    private String imatge;
    private String color;
    private String nomDelVideojoc;

    public Personatge(String nom, String imatge, String color, String nomDelVideojoc) {
        this.nom = nom;
        this.imatge = imatge;
        this.color = color;
        this.nomDelVideojoc = nomDelVideojoc;
    }

    public String getNom() {
        return nom;
    }

    public String getImatge() {
        return imatge;
    }

    public String getColor() {
        return color;
    }

    public String getNomDelVideojoc() {
        return nomDelVideojoc;
    }

    @Override
    public String toString() {
        return "Personatge{" +
                "nom='" + nom + '\'' +
                ", imatge='" + imatge + '\'' +
                ", color='" + color + '\'' +
                ", nomDelVideojoc='" + nomDelVideojoc + '\'' +
                '}';
    }
}
