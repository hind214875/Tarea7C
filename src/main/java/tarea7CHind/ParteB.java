/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7CHind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 *
 * @author hinda
 */
public class ParteB {

    public static void main(String[] args) {
        /*a) Obtener todos los registros de 1ESOA que no son de la asignatura MUS.*/
        String idFichero = "./hor_curso_1920_final.csv";
        //crear lista cursos
        ArrayList<Curso> listaCursos = LeerFichero.leerFichero(idFichero);

        System.out.println("Todos los registros de ESOA que no son de MUS: ");
        listaCursos.stream()
                .filter(c -> c.getNombreCurso().equalsIgnoreCase("1ESOA") && !(c.getAsignatura().equalsIgnoreCase("MUS")))
                .forEach(System.out::println);//add the number in the begining

        //b) Contar las horas que se imparten de la asignatura PROGR
        long contador = listaCursos.stream()
                .filter(c -> c.getAsignatura().equalsIgnoreCase("PROGR"))
                .count();
        System.out.println("\ncontar horas de asignatura Prog:" + contador);

        /*c) Obtener una lista con las iniciales del profesorado que imparte la asignatura REL, 
             ordenadas en orden inverso al orden alfabético*/
        System.out.println("\nlista iniciales del profesorado que imparte asignatura REL: ");
        listaCursos.stream()
                .filter(c -> c.getAsignatura().equalsIgnoreCase("REL"))
                .map(c -> c.getInicialesProf())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /*d) Obtener en una lista las aulas donde imparte clase el profesor "JFV"  */
        System.out.println("lista las aulas donde imparte clase el profesor \"JFV\" ");
        listaCursos.stream()
                .filter(c -> c.getInicialesProf().equalsIgnoreCase("JFV"))
                .map(c -> c.getAula())
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        /*e) Contar el número de asignaturas distintas que hay*/
        long numeroAsig = listaCursos.stream()
                .map(c -> c.getAsignatura())
                .distinct()
                .count();
        System.out.println("numero de asignaturas es: " + numeroAsig);
        /*f. Contar el total de horas que se imparten a última hora de la mañana.*/
        long totalHoras = listaCursos.stream()
                .filter(c -> c.getHoras() == 7)
                .map(c -> c.getHoras())
                .count();
        System.out.println("horas que se imparten a última hora de la mañana: " + totalHoras);

        /*Mostrar por consola los profesores que tienen clase a primera hora de la mañana.*/
        System.out.println("\nlos profesores que tienen clase a primera hora de la mañana");
        listaCursos.stream()
                .filter(c -> c.getHoras() == 1)
                .map(c -> c.getInicialesProf())
                .forEach(System.out::println);
    }
}
