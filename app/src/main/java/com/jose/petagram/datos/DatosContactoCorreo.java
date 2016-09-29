package com.jose.petagram.datos;

public class DatosContactoCorreo {
    private String sNombreCorreo;
    private String sCorreoElectronico;
    private String sMensajeCorreo;

    public DatosContactoCorreo(String sNombreCorreo, String sCorreoElectronico, String sMensajeCorreo) {
        this.sCorreoElectronico = sCorreoElectronico;
        this.sMensajeCorreo = sMensajeCorreo;
        this.sNombreCorreo = sNombreCorreo;
    }

    public String getsCorreoElectronico() {
        return sCorreoElectronico;
    }

    public String getsMensajeCorreo() {
        return sMensajeCorreo;
    }

    public String getsNombreCorreo() {
        return sNombreCorreo;
    }

}
