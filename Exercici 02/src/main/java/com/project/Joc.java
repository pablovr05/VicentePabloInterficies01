package com.project;

public class Joc {
    private String nom;
    private int any;
    private String tipo;
    private String descripcion;
    private String imagen;

    public Joc(String nom, int any, String tipo, String descripcion, String imagen) {
        this.nom = nom;
        this.any = any;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNom() {
        return nom;
    }

    public int getAny() {
        return any;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Joc{" +
                "nombre='" + nom + '\'' +
                ", any=" + any +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
