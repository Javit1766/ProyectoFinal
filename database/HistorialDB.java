package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialDB {

    String historial [];

    private static final String ARCHIVO = "historial_calculadora.txt";

    // Guardar una operación en el archivo
    public static void guardarOperacion(String operacion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            bw.write(operacion);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar operación: " + e.getMessage());
        }
    }

    // Leer todas las operaciones del historial
    public static List<String> leerHistorial() {
        List<String> historial = new ArrayList<>();
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return historial; // Si el archivo no existe, devuelve lista vacía
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                historial.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer historial: " + e.getMessage());
        }

        return historial;
    }

    // Limpiar todo el historial
    public static void limpiarHistorial() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            bw.write(""); // Sobrescribe con vacío
        } catch (IOException e) {
            System.out.println("Error al limpiar historial: " + e.getMessage());
        }
    }
}
