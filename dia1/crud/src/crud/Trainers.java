/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author pc1
 */
public class Trainers {
    private static int nextId = 1;
    private int idTrainer;
    private int n_documento;
    private String nombre;
    private String apellidotrainer;
    private int n_celular;
    private String jornada;
    
    public Trainers(int n_documento, int n_celular, String nombre, String apellido, int n_celular1, String jornada){
        this.idTrainer= nextId++;
        this.n_documento = n_documento;
        this.nombre = nombre;
        this.apellidotrainer = apellido;
        this.n_celular = n_celular;
        this.jornada = "No asignado";
    }
    
    public int getId() {
        return idTrainer;
    }

    public void setId(int idTrainer) {
        this.idTrainer = idTrainer;
    }
    
    public int getN_documento() {
        return n_documento;
    }

    public void setN_documento(int n_documento) {
        this.n_documento = n_documento;
    }
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public String getApellido() {
        return apellidotrainer;
    }

    public void setApellido(String apellido) {
        this.apellidotrainer = apellido;
    }
    
    public int getN_celular() {
        return n_celular;
    }

    public void setN_celular(int n_celular) {
        this.n_celular = n_celular;
    }
   
    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    @Override
    public String toString() {
        return "Trainers{" +
                "id=" + idTrainer +
                ", n_documento=" + n_documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellidotrainer + '\'' +
                ", n_celular=" + n_celular +
                ", jornada='" + jornada + '\'' +
                '}';
    }
}
    
