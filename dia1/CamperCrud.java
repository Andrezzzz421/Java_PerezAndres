/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
/**
 *
 * @author andres
 */

public class CamperCrud {
    private final Camper[] campers;
    private int contador;

    public CamperCrud(int cantidad) {
        this.campers = new Camper[cantidad];
        this.contador = 0;
    }

    public void crearCamper(int id, int n_documento, String nombre, String nombre2, String apellido, String apellido2, String ciudad, String direccion, String acudiente, int n_celular, int n_fijo, String estado, String riesgo) {
        if (contador < campers.length) {
            campers[contador++] = new Camper(id, n_documento, nombre, nombre2, apellido, apellido2, ciudad, direccion, acudiente, n_celular, n_fijo, estado, riesgo);
        } else {
            System.out.println("Array lleno, no se puede ingresar más datos");
        }
    }
    public void leerCamper(){
        for (int i = 0; i < contador; i++){
            System.out.println(campers[i]);
        }
    }
    public void actualizarCamper(int id, int n_documento, String nombre, String nombre2, String apellido, String apellido2, String ciudad, String direccion, String acudiente, int n_celular, int n_fijo, String estado, String riesgo){
        for (int i = 0; i < contador; i++){
            if(campers[i].getId() == id) {
            campers[i].setN_documento(n_documento);
            campers[i].setNombre(nombre);
            campers[i].setNombre2(nombre2);
            campers[i].setApellido(apellido);
            campers[i].setApellido2(apellido2);
            campers[i].setCiudad(ciudad);
            campers[i].setDireccion(direccion);
            campers[i].setAcudiente(acudiente);
            campers[i].setN_celular(n_celular);
            campers[i].setN_fijo(n_fijo);
            campers[i].setEstado(estado);
            campers[i].setRiesgo(riesgo);
            System.out.println("Camper con id " + id + " ha sido actualizado.");
            return;
            }
        }
        System.out.println("Camper con id " + id + " no encontrado.");
    }
    public boolean eliminarCamper(int id){
        for (int i = 0; i < contador; i++){
            if(campers[i].getId() == id){
                for (int j = i; j < contador - 1; j++){
                    campers[j] = campers[j + 1];
                }
                campers[--contador] = null;
                return true;
            }
        }
        return false;
    }
}
