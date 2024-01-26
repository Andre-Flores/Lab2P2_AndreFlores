package lab2p2_andreflores_;

import java.util.Date;

public class conferenciasVirtuales {

    String tituloConf;
    String conferencista;
    Date fecha;
    String duracion;
    String enlaceAcceso;

    public conferenciasVirtuales(String tituloConf, String conferencista, Date fecha, String duracion, String enlaceAcceso) {
        this.tituloConf = tituloConf;
        this.conferencista = conferencista;
        this.fecha = fecha;
        this.duracion = duracion;
        this.enlaceAcceso = enlaceAcceso;
    }

    public String getTituloConf() {
        return tituloConf;
    }

    public String getConferencista() {
        return conferencista;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getEnlaceAcceso() {
        return enlaceAcceso;
    }

    public void setTituloConf(String tituloConf) {
        this.tituloConf = tituloConf;
    }

    public void setConferencista(String conferencista) {
        this.conferencista = conferencista;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setEnlaceAcceso(String enlaceAcceso) {
        this.enlaceAcceso = enlaceAcceso;
    }

    @Override
    public String toString() {
        return "conferenciasVirtuales{" + "tituloConf=" + tituloConf + ", conferencista=" + conferencista + ", fecha=" + fecha + ", duracion=" + duracion + ", enlaceAcceso=" + enlaceAcceso + '}';
    }

}
