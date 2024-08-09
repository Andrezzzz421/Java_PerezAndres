/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Singleton;

/**
 *
 * @author pc1
 */
public class Main {
    public static void main(String[] args) {
        // Se obtiene la única instancia de Singleton
        Singleton singleton = Singleton.getInstancia();

        // Se utiliza la instancia para llamar a un método
        singleton.mostrarMensaje();
    }
}

