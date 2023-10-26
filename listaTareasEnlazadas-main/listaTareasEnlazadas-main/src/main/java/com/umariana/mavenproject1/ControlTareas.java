package com.umariana.mavenproject1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
/**
 *
 * @author valentina
 */
public class ControlTareas {

    /*---------------/
    *Atributos
    *----------------*/
    public static Tarea cabeza;

    /*---------------/
    * Metodos
    *----------------*/
    public ControlTareas() {
        cabeza = null;
    }

    public static void agregarTarea(Tarea nuevaTarea) {
        if (cabeza == null) {
            cabeza = nuevaTarea;
        } else {
            Tarea actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevaTarea);
        }
    }

    public static Tarea buscarTareaPorTitulo(String titulo) {

        Tarea actual = cabeza;
        while (actual != null) {
            if (actual.getTitulo().equals(titulo)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public static void eliminarArchivo(ServletContext context, String nombreUsuario) {
        String relativePath = "/data/tareas_" + nombreUsuario + ".txt";
        String absPath = context.getRealPath(relativePath);
        File archivoCargar = new File(absPath);

        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoCargar))) {
            System.out.println("aqui");
            escribir.write("");
            escribir.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static void eliminarTarea(Tarea tareaAEliminar, ServletContext context, String nombreUsuario) {

        if (cabeza == null) {
            return; // La lista está vacía, no hay nada que eliminar.
        }

        if (cabeza == tareaAEliminar) {
            cabeza = cabeza.getSiguiente();
            guardarTareasEnArchivo(context, nombreUsuario);
            return;
        }

        Tarea actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente() == tareaAEliminar) {
                actual.setSiguiente(tareaAEliminar.getSiguiente());
                guardarTareasEnArchivo(context, nombreUsuario);
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public static void limpiarListaDeTareas() {
        cabeza = null;
    }

    /**
     * Metodo para guardar informacion en un arvhibo de texto
     *
     * @param nombreArchivo
     */
    public static void guardarTareasEnArchivo(ServletContext context, String nombreUsuario) {
        String relativePath = "/data/tareas_" + nombreUsuario + ".txt";
        String absPath = context.getRealPath(relativePath);
        File archivoGuardar = new File(absPath);

        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoGuardar));

            Tarea actual = cabeza; // Usamos la cabeza de la lista enlazada
            while (actual != null) {
                escritor.write("ID: " + actual.getId());
                escritor.newLine();
                escritor.write("Título: " + actual.getTitulo());
                escritor.newLine();
                escritor.write("Descripción: " + actual.getDescripcion());
                escritor.newLine();
                escritor.write("Fecha de vencimiento: " + actual.getFechaVencimiento());
                escritor.newLine();
                escritor.write("-----------------------");
                escritor.newLine();

                actual = actual.getSiguiente(); // Avanzamos al siguiente nodo en la lista
            }

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para cargar
     *
     * @param nombreArchivo
     */
    public static void cargarTareasDesdeArchivo(ServletContext context, String nombreUsuario) {

        limpiarListaDeTareas();
        String relativePath = "/data/tareas_" + nombreUsuario + ".txt";
        String absPath = context.getRealPath(relativePath);
        File archivoCargar = new File(absPath);
        boolean ve = archivoCargar.length() != 0;
        System.out.println("desde cargata: " + relativePath + " vetificando si tiene contenido: " + ve);

        if (archivoCargar.length() != 0) {
            try (BufferedReader leyendo = new BufferedReader(new FileReader(archivoCargar))) {
                String id = null;
                String titulo = null;
                String descripcion = null;
                String fechaVencimiento = null;

                String lineaPorLinea;
                while ((lineaPorLinea = leyendo.readLine()) != null) {
                    if (lineaPorLinea.startsWith("ID:")) {
                        id = lineaPorLinea.substring(lineaPorLinea.indexOf(":") + 1).trim();
                    } else if (lineaPorLinea.startsWith("Título:")) {
                        titulo = lineaPorLinea.substring(lineaPorLinea.indexOf(":") + 1).trim();
                    } else if (lineaPorLinea.startsWith("Descripción:")) {
                        descripcion = lineaPorLinea.substring(lineaPorLinea.indexOf(":") + 1).trim();
                    } else if (lineaPorLinea.startsWith("Fecha de vencimiento:")) {
                        fechaVencimiento = lineaPorLinea.substring(lineaPorLinea.indexOf(":") + 1).trim();

                        // Crea una nueva tarea y agrégala a la lista de tareas del usuario
                        Tarea nuevaTarea = new Tarea(id, titulo, descripcion, fechaVencimiento);
                        System.out.println("se creo nueva tarea: " + nuevaTarea.getFechaVencimiento());
                        agregarTarea(nuevaTarea);

                        // Restablece las variables para la siguiente tarea
                        id = null;
                        titulo = null;
                        descripcion = null;
                        fechaVencimiento = null;
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }

    public static List<Tarea> obtenerTodasLasTareas() {
        List<Tarea> listaTodasLasTareas = new ArrayList<>();
        Tarea actual = cabeza; // Comenzamos desde la cabeza de la lista enlazada

        while (actual != null) {
            listaTodasLasTareas.add(actual);
            actual = actual.getSiguiente(); // Avanzamos al siguiente nodo en la lista
        }

        return listaTodasLasTareas;
    }

    public static void editarTarea(Tarea tarea, String nuevoTitulo, String nuevaDescripcion, String nuevaFechaVencimiento, ServletContext context, String nombreUsuario) {

        if (tarea == null) {

            return;
        }

        tarea.setTitulo(nuevoTitulo);
        tarea.setDescripcion(nuevaDescripcion);
        tarea.setFechaVencimiento(nuevaFechaVencimiento);

        guardarTareasEnArchivo(context, nombreUsuario);
    }

    public static Tarea buscarTareaPorId(String id) {
        Tarea actual = cabeza;
        System.out.println("desde buscar por id: " + id);
        while (actual != null) {

            if (actual.getId().equals(id)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    public static boolean existeTareaConId(String id) {
        Tarea actual = cabeza; 

        while (actual != null) {
           
            if (actual.getId().equals(id)) {
                return true; 
            }
            actual = actual.getSiguiente(); 
        }

        return false; // No se encontró ninguna tarea con ese ID
    }

}
