/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea7CHind;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hinda
 */
public class EscribirJson {
     //metodo escritura fichero json
    public static void escrituraFicheroJson(String idFichero, ArrayList<Curso> lista) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        // Permite a mapeador usar fechas según java time
        // mapeador.registerModule(new JavaTimeModule());   
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);
        // Escribe en un fichero JSON 
        mapeador.writeValue(new File(idFichero), lista); 

    }
}
