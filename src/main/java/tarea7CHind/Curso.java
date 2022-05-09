/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7CHind;

/**
 *
 * @author hinda
 */
class Curso {
     //Atributos
    private String id;
    private String nombreCurso;
    private String inicialesProf;
    private String asignatura;
    private String aula;
    private int diaSemana;
    private int horas;
    
    //constrectores

    public Curso() {
    }

    public Curso(String id, String nombreCurso, String inicialesProf, String asignatura, String aula, int diaSemana, int horas) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.inicialesProf = inicialesProf;
        this.asignatura = asignatura;
        this.aula = aula;
        this.diaSemana = diaSemana;
        this.horas = horas;
    }
    
    //getters y setters 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getInicialesProf() {
        return inicialesProf;
    }

    public void setInicialesProf(String inicialesProf) {
        this.inicialesProf = inicialesProf;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    //tostring

    @Override
    public String toString() {
        return id + ";" + nombreCurso +";" + inicialesProf + ";" + asignatura + ";" + aula + ";" + diaSemana +";" + horas ;
    }
    
}
