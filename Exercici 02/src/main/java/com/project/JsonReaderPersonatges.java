package com.project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonReaderPersonatges {

    public static List<Personatge> crearPersonajesDesdeJSON(String rutaJSON) {
        List<Personatge> personajes = new ArrayList<>();

        try {
            // Leer el contenido del archivo JSON
            String contenidoJSON = new String(Files.readAllBytes(Paths.get(rutaJSON))).trim();

            // Convertir el contenido a un JSONArray
            JSONArray jsonArray = new JSONArray(contenidoJSON);

            // Recorrer el JSONArray y crear objetos Personatge
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nom = jsonObject.getString("nom");
                String imatge = jsonObject.getString("imatge");
                String color = jsonObject.getString("color");
                String nomDelVideojoc = jsonObject.getString("nom_del_videojoc");

                // Crear el objeto Personatge y añadirlo a la lista
                personajes.add(new Personatge(nom, imatge, color, nomDelVideojoc));
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
        }

        return personajes;
    }
}
