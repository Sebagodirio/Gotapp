package com.example.gotapp;

import android.net.Uri;

public class Personaje {

    private Integer id;
    private Uri imagen;
    private String nombre;
    private String genero;
    private String nacimiento;
    private String cultura;

    public Personaje(Integer id, Uri imagen, String nombre, String genero, String nacimiento, String cultura) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.genero = genero;
        this.nacimiento = nacimiento;
        this.cultura = cultura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Uri getImagen() {
        return imagen;
    }

    public void setImagen(Uri imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }
}
