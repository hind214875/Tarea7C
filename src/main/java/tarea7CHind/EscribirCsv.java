/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7CHind;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hinda
 */
public class EscribirCsv {

    public static void escrituraFicheroCsv(String idFichero, ArrayList<Curso> lista ) {

        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (Curso obj : lista) {
                flujo.write(obj.toString());
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
