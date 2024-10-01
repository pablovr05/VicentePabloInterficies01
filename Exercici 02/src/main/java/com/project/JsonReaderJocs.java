package com.project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonReaderJocs {

    public static List<Joc> crearJocsDesdeJSON(String rutaJSON) {
        List<Joc> jocs = new ArrayList<>();

        try {
            // Leer el contenido del archivo JSON
            String contenidoJSON = new String(Files.readAllBytes(Paths.get(rutaJSON))).trim();

            // Convertir el contenido a un JSONArray
            JSONArray jsonArray = new JSONArray(contenidoJSON);

            // Recorrer el JSONArray y crear objetos Joc
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                String nombre = jsonObject.getString("nom");
                int any = jsonObject.getInt("any");
                String tipo = jsonObject.getString("tipus");
                String descripcion = jsonObject.getString("descripcio");
                String imagen = jsonObject.getString("imatge");

                // Crear el objeto Joc y añadirlo a la lista
                jocs.add(new Joc(nombre, any, tipo, descripcion, imagen));
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
        }

        return jocs;
    }
}
