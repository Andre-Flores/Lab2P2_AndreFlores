/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_andreflores_;

import java.util.Date;

public class CursosenLinea {
    String tituloCursos;
    String instructorCursos;
    int duracionenSemanasCursos;
    String plataformadeEnseniaza;

    public CursosenLinea(String tituloCursos, String instructorCursos, int duracionenSemanasCursos, String plataformadeEnseniaza) {
        this.tituloCursos = tituloCursos;
        this.instructorCursos = instructorCursos;
        this.duracionenSemanasCursos = duracionenSemanasCursos;
        this.plataformadeEnseniaza = plataformadeEnseniaza;
    }

    public String getTituloCursos() {
        return tituloCursos;
    }

    public String getInstructorCursos() {
        return instructorCursos;
    }

    public int getDuracionenSemanasCursos() {
        return duracionenSemanasCursos;
    }

    public String getPlataformadeEnseniaza() {
        return plataformadeEnseniaza;
    }

    public void setTituloCursos(String tituloCursos) {
        this.tituloCursos = tituloCursos;
    }

    public void setInstructorCursos(String instructorCursos) {
        this.instructorCursos = instructorCursos;
    }

    public void setDuracionenSemanasCursos(int duracionenSemanasCursos) {
        this.duracionenSemanasCursos = duracionenSemanasCursos;
    }

    public void setPlataformadeEnseniaza(String plataformadeEnseniaza) {
        this.plataformadeEnseniaza = plataformadeEnseniaza;
    }

    @Override
    public String toString() {
        return "CursosenLinea{" + "tituloCursos=" + tituloCursos + ", instructorCursos=" + instructorCursos + ", duracionenSemanasCursos=" + duracionenSemanasCursos + ", plataformadeEnseniaza=" + plataformadeEnseniaza + '}';
    }
    
}
