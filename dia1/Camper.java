/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author andres
 */
public class Camper {
    private int id;
    private int n_documento;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String ciudad;
    private String direccion;
    private String acudiente;
    private int n_celular;
    private int n_fijo;
    private String estado;
    private String riesgo;
    
    public Camper(int id, int n_documento, String nombre, String nombre2, String apellido, String apellido2, String ciudad, String direccion, String acudiente, int n_celular, int n_fijo, String estado, String riesgo) {
        this.id = id;
        this.n_documento = n_documento;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.acudiente = acudiente;
        this.n_celular = n_celular;
        this.n_fijo = n_fijo;
        this.estado = estado;
        this.riesgo = riesgo;
    }
    
    public int getId() {
    return id;
    }

    public int getN_documento() {
        return n_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public int getN_celular() {
        return n_celular;
    }

    public int getN_fijo() {
        return n_fijo;
    }

    public String getEstado() {
        return estado;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setN_documento(int n_documento) {
        this.n_documento = n_documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public void setN_celular(int n_celular) {
        this.n_celular = n_celular;
    }

    public void setN_fijo(int n_fijo) {
        this.n_fijo = n_fijo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }
    
    @Override
        public String toString() {
        return "Camper{id=" + id + 
               ", n_documento=" + n_documento + 
               ", nombre='" + nombre + '\'' + 
               ", segundo nombre ='" + nombre2 + '\'' + 
               ", apellido='" + apellido + '\'' + 
               ", segundo apellido ='" + apellido2 + '\'' + 
               ", ciudad='" + ciudad + '\'' + 
               ", direccion='" + direccion + '\'' + 
               ", acudiente='" + acudiente + '\'' + 
               ", n_celular=" + n_celular + 
               ", n_fijo=" + n_fijo + 
               ", estado='" + estado + '\'' + 
               ", riesgo='" + riesgo + '\'' + 
               '}';
    }
}

