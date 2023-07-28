package lab2p2_andreflores;

public class ClassChefs {

    private String nombre;
    private int edad;
    private String turno;
    private int numEstrellasMichelin;
    private double sueldo;

    public ClassChefs(String nombre, int edad, String turno, int numEstrellasMichelin, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.turno = turno;
        this.numEstrellasMichelin = numEstrellasMichelin;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getNumEstrellasMichelin() {
        return numEstrellasMichelin;
    }

    public void setNumEstrellasMichelin(int numEstrellasMichelin) {
        this.numEstrellasMichelin = numEstrellasMichelin;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


    @Override
    public String toString() {
        return "Chef{"
                + "nombre='" + nombre + '\''
                + ", edad=" + edad
                + ", turno='" + turno + '\''
                + ", numEstrellasMichelin=" + numEstrellasMichelin
                + ", sueldo=" + sueldo
                + '}';

    }

}
