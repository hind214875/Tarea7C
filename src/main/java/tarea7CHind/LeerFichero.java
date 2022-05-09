/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7CHind;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class LeerFichero {

    //metodo leer el fichero
    public static ArrayList<Curso> leerFichero(String idFichero) {

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Curso> listaAux = new ArrayList<>();
        
        System.out.println("Leyendo el fichero: " + idFichero);
        try (Scanner datosFichero = new Scanner(new File(idFichero))) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                linea = linea.replaceAll("\"", "");//para quitar las comillas dobles
                linea = linea.replaceAll("\\s+", "");//para quitar espacios en blanco
                // Se guarda en el array de String cada elemento de la
                tokens = linea.split(";");
                //crear objeto 
                Curso curso = new Curso();

                curso.setId(tokens[0]);
                curso.setNombreCurso(tokens[1]);
                curso.setInicialesProf(tokens[2]);
                curso.setAsignatura(tokens[3]);
                curso.setAula(tokens[4]);
                curso.setDiaSemana(Integer.parseInt(tokens[5]));
                curso.setHoras(Integer.parseInt(tokens[6]));

                listaAux.add(curso);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaAux;
    }
}
