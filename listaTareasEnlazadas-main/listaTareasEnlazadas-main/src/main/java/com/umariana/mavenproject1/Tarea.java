
package com.umariana.mavenproject1;

/**
 *
 * @author valentina
 */
public class Tarea {
    /*---------/
    *Atributos
    *---------*/
    private String id;
    private String titulo;
    private String descripcion;
    private String fechaVencimiento;
    private Tarea siguiente;


    
    public Tarea() {
    }

     public Tarea(String id, String titulo, String descripcion, String fechaVencimiento) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.siguiente = null;
    }
     
     
    /**
     * Metodo para verificar si siguiente tarea es difetente de null
     * @return 
     */ 
    public Tarea getSiguiente() {
        return siguiente;
    }
    
    /**
     * Metodo para agregar una nueva tarea
     * @param siguiente 
     */
    public void setSiguiente(Tarea siguiente) {
        this.siguiente = siguiente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
