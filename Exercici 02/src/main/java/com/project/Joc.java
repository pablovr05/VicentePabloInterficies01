package com.project;

public class Joc {
    private String nombre;
    private int any;
    private String tipo;
    private String descripcion;
    private String imagen;

    public Joc(String nombre, int any, String tipo, String descripcion, String imagen) {
        this.nombre = nombre;
        this.any = any;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
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
                "nombre='" + nombre + '\'' +
                ", any=" + any +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
