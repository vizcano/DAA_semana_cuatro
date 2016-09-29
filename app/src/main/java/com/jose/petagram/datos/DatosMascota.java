package com.jose.petagram.datos;

public class DatosMascota {
    private String nombreMascota;
    private String ratingMascota;
    private int fotoMascota;

    public DatosMascota(String nombreMascota, String ratingMascota, int fotoMascota) {
        this.nombreMascota = nombreMascota;
        this.ratingMascota = ratingMascota;
        this.fotoMascota = fotoMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRatingMascota() {
        return ratingMascota;
    }

    public void setRatingMascota(String ratingMascota) {
        this.ratingMascota = ratingMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }
}
