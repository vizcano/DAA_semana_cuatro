package com.jose.petagram.datos;

public class PerfilMascota {
    private int fotoMascota;
    private String ratingMascota;

    public PerfilMascota(int fotoMascota, String ratingMascota) {
        this.fotoMascota = fotoMascota;
        this.ratingMascota = ratingMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public String getRatingMascota() {
        return ratingMascota;
    }
}
