
package lab2p2_andreflores_;

import java.util.Date;

public class Articulos {
    String tituloArt;
    String autorArt;
    String TemaArt;
    Date fechaPublicacionArt;
    boolean accesoenLineaArt;

    public Articulos(String tituloArt, String autorArt, String TemaArt, Date fechaPublicacionArt, boolean accesoenLineaArt) {
        this.tituloArt = tituloArt;
        this.autorArt = autorArt;
        this.TemaArt = TemaArt;
        this.fechaPublicacionArt = fechaPublicacionArt;
        this.accesoenLineaArt = accesoenLineaArt;
    }

    public String getTituloArt() {
        return tituloArt;
    }

    public String getAutorArt() {
        return autorArt;
    }

    public String getTemaArt() {
        return TemaArt;
    }

    public Date getFechaPublicacionArt() {
        return fechaPublicacionArt;
    }

    public boolean isAccesoenLineaArt() {
        return accesoenLineaArt;
    }

    public void setTituloArt(String tituloArt) {
        this.tituloArt = tituloArt;
    }

    public void setAutorArt(String autorArt) {
        this.autorArt = autorArt;
    }

    public void setTemaArt(String TemaArt) {
        this.TemaArt = TemaArt;
    }

    public void setFechaPublicacionArt(Date fechaPublicacionArt) {
        this.fechaPublicacionArt = fechaPublicacionArt;
    }

    public void setAccesoenLineaArt(boolean accesoenLineaArt) {
        this.accesoenLineaArt = accesoenLineaArt;
    }

    @Override
    public String toString() {
        return "Articulos{" + "tituloArt=" + tituloArt + ", autorArt=" + autorArt + ", TemaArt=" + TemaArt + ", fechaPublicacionArt=" + fechaPublicacionArt + ", accesoenLineaArt=" + accesoenLineaArt + '}';
    }
    
}
