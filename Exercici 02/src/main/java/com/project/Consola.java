package com.project;

import java.time.LocalDate;

public class Consola {
    private String nombre;
    private LocalDate fechaLanzamiento;
    private String procesador;
    private String color;
    private int unidadesVendidas;
    private String imagen;

    public Consola(String nombre, LocalDate fechaLanzamiento, String procesador, String color, int unidadesVendidas, String imagen) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.procesador = procesador;
        this.color = color;
        this.unidadesVendidas = unidadesVendidas;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getProcesador() {
        return procesador;
    }

    public String getColor() {
        return color;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public String getImagen() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Consola{" +
                "nombre='" + nombre + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", procesador='" + procesador + '\'' +
                ", color='" + color + '\'' +
                ", unidadesVendidas=" + unidadesVendidas +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
