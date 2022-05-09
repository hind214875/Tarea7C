/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7CHind;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author hinda
 */
public class Main {

    //metodos
    public static String menu(TreeSet<String> iniciales) {
        Object[] options = iniciales.toArray();
        Object selectionObject = JOptionPane.showInputDialog(null, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return selectionObject.toString();
    }

    public static ArrayList<Curso> horarioPorInicial(String inicial, ArrayList<Curso> lista) {
        ArrayList<Curso> listaHorario = new ArrayList<>();

        for (Curso obj : lista) {
            if (obj.getInicialesProf().equals(inicial)) {
                listaHorario.add(obj);
            }
        }
        return listaHorario;
    }

    public static ArrayList<Curso> horarioPorGrupo(String grupo, ArrayList<Curso> lista) {
        ArrayList<Curso> listaHorario = new ArrayList<>();

        for (Curso obj : lista) {
            if (obj.getNombreCurso().equals(grupo)) {
                listaHorario.add(obj);
            }
        }
        return listaHorario;
    }

    public static void main(String[] args) {
        //Una vez guardados los objetos en la lista, ésta debe quedar ordenada primero por día y luego por hora.
        String idFichero = "./hor_curso_1920_final.csv";
        //crear lista cursos
        ArrayList<Curso> listaCursos = LeerFichero.leerFichero(idFichero);

        //ordenar por dia
        Collections.sort(listaCursos, ((Curso c1, Curso c2) -> Integer.compare(c1.getDiaSemana(), c2.getDiaSemana())));
        //mostrar la lista ordenada por dia
        System.out.println("la lista ordenada por dia\n");
        listaCursos.forEach(System.out::println);
        //mostrar la lista ordenada por horas
        System.out.println("\nmostrar la lista ordenada por horas");
        Collections.sort(listaCursos, ((Curso c1, Curso c2) -> Integer.compare(c1.getHoras(), c2.getHoras())));
        listaCursos.forEach(System.out::println);

        /*El conjunto de grupos y de iniciales de profesores se guardarán en dos estructuras SET, ya que no debe haber duplicados.
          Estas estructuras deben estar ordenadas siguiendo el orden alfabético. */
        TreeSet<String> incialesProfs = new TreeSet<>();
        for (Curso obj : listaCursos) {
            incialesProfs.add(obj.getInicialesProf());
        }
        //mostrar la lista de incialesProfs
        System.out.println("\n la lista de incialesProfs: ");
        incialesProfs.forEach(System.out::println);

        TreeSet<String> CursoImplicado = new TreeSet<>();
        for (Curso obj : listaCursos) {
            CursoImplicado.add(obj.getNombreCurso());
        }

        System.out.println("\n la lista de CursoImplicado: ");
        CursoImplicado.forEach(System.out::println);

        /*Otras estructuras de datos auxiliares que estimes convenientes, siempre y cuando esté debidamente justificado su uso.*/

 /*Cuando toda la información esté en las estructuras de datos, la aplicación proporciona dos opciones:
a) Consultar horarios por profesor/a.
b) Consultar horarios por grupo.*/
        boolean solicitarDatos;
        String opcion = null;
        String choice;

        do {

            do {
                solicitarDatos = true;
                try {
                    opcion = (JOptionPane.showInputDialog(null, "\n<html><div color=red>Menu Principal</div></html>\n"
                            + "\na. Consultar horarios por profesor\n"
                            + "\nb. Consultar horarios por grupo\n"
                            + "\nc. Salir\n"));
                    solicitarDatos = false;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Se ha introducido texto en lugar de números. Vuelva a introducir los datos");
                }

            } while (solicitarDatos);

            switch (opcion) {
                case "a":
                    choice = menu(incialesProfs);
                     {
                        try {
                            EscribirJson.escrituraFicheroJson("./" + choice + ".json", horarioPorInicial(choice, listaCursos));
                            JOptionPane.showMessageDialog(null, "La escritura con excito del fichero json");
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;

                case "b":
                    choice = menu(CursoImplicado);
                     {
                        EscribirCsv.escrituraFicheroCsv("./" + choice + ".csv", horarioPorGrupo(choice, listaCursos));
                        JOptionPane.showMessageDialog(null, "La escritura con excito del fichero Csv");
                    }
                    break;

                case "c":
                    System.out.println("Salir");
                    break;

            }

        } while (!(opcion.equalsIgnoreCase("c")));

    }
}
