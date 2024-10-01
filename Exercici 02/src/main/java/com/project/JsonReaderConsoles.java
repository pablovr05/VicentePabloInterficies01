package com.project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JsonReaderConsoles {

    public static List<Consola> crearConsolesDesdeJSON(String rutaJSON) {
        List<Consola> consoles = new ArrayList<>();
    
        try {
            // Leer el contenido del archivo JSON
            String contenidoJSON = new String(Files.readAllBytes(Paths.get(rutaJSON))).trim();
    
            // Convertir el contenido a un JSONArray
            JSONArray jsonArray = new JSONArray(contenidoJSON);
    
            // Recorrer el JSONArray y crear objetos Consola
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                
                String nombre = jsonObject.getString("nom");
    
                // Obtener la fecha como String
                String dateString = jsonObject.getString("data");
                // Normalizar el formato de fecha a "yyyy-MM-dd"
                dateString = normalizeDate(dateString);
                LocalDate data = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
    
                String procesador = jsonObject.getString("procesador");
                String color = jsonObject.getString("color");
                int venudes = jsonObject.getInt("venudes");
                String imagen = jsonObject.getString("imatge");
    
                // Crear el objeto Consola y añadirlo a la lista
                consoles.add(new Consola(nombre, data, procesador, color, venudes, imagen));
            }
    
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("Error al procesar el JSON: " + e.getMessage());
        }
    
        return consoles;
    }
    
    private static String normalizeDate(String date) {
        String[] parts = date.split("-");
        String year = parts[0];
        String month = (parts.length > 1 && parts[1].length() == 1) ? "0" + parts[1] : parts[1];
        String day = (parts.length > 2 && parts[2].length() == 1) ? "0" + parts[2] : parts[2];
    
        return year + "-" + month + "-" + day;
    }
    
}
