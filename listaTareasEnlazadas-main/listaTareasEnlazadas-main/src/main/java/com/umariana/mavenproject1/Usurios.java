
package com.umariana.mavenproject1;

import java.util.ArrayList;
/**
 *
 * @author omar salazar
 */



public class Usurios {
      
    /*-------------------------------------------------------
     * Atributos 
     *-------------------------------------------------*/
    
    private String cedula;
    private String nombre_usuario;
    private String contrasenia;
    private ArrayList<Tarea> tareas;

 
     
     /*---------------/
      * Metodos
      *--------------*/

     public Usurios(String cedula, String nombre_usuario, String contrasenia) {
        this.cedula = cedula;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public ArrayList<Tarea> obtenerTareas() {
        return tareas;
    }
    public String getCedula() {
         return cedula;
     }
    public void setCedula(String cedula) {
         this.cedula = cedula;
     }
     public String getNombre_usuario() {
         return nombre_usuario;
     }
     public void setNombre_usuario(String nombre_usuario) {
         this.nombre_usuario = nombre_usuario;
     }
     public String getContrasenia() {
         return contrasenia;
     }
     public void setContrasenia(String contrasenia) {
         this.contrasenia = contrasenia;
     }
 
 
}
