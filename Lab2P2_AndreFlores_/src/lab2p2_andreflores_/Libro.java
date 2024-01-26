
package lab2p2_andreflores_;

import java.util.Date;

public class Libro {
    String tituloLib;
    String autorLib;
    String generoLib;
    String anioPublicacionLib;
    boolean accesoenLineaLib;

    public Libro(String tituloLib, String autorLib, String generoLib, String anioPublicacionLib, boolean accesoenLineaLib) {
        this.tituloLib = tituloLib;
        this.autorLib = autorLib;
        this.generoLib = generoLib;
        this.anioPublicacionLib = anioPublicacionLib;
        this.accesoenLineaLib = accesoenLineaLib;
    }

    public String getTituloLib() {
        return tituloLib;
    }

    public String getAutorLib() {
        return autorLib;
    }

    public String getGeneroLib() {
        return generoLib;
    }

    public String getAnioPublicacionLib() {
        return anioPublicacionLib;
    }

    public boolean isAccesoenLineaLib() {
        return accesoenLineaLib;
    }

    public void setTituloLib(String tituloLib) {
        this.tituloLib = tituloLib;
    }

    public void setAutorLib(String autorLib) {
        this.autorLib = autorLib;
    }

    public void setGeneroLib(String generoLib) {
        this.generoLib = generoLib;
    }

    public void setAnioPublicacionLib(String anioPublicacionLib) {
        this.anioPublicacionLib = anioPublicacionLib;
    }

    public void setAccesoenLineaLib(boolean accesoenLineaLib) {
        this.accesoenLineaLib = accesoenLineaLib;
    }

    @Override
    public String toString() {
        return "Libro{" + "tituloLib=" + tituloLib + ", autorLib=" + autorLib + ", generoLib=" + generoLib + ", anioPublicacionLib=" + anioPublicacionLib + ", accesoenLineaLib=" + accesoenLineaLib + '}';
    }
    
}
