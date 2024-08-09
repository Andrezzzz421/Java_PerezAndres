/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Prototype;

/**
 *
 * @author pc1
 */
public class Main {
    public static void main(String[] args) {
        Circulo circuloOriginal = new Circulo();
        circuloOriginal.setId("1");

        Circulo circuloClonado = (Circulo) circuloOriginal.clonar();
        System.out.println("Forma : " + circuloClonado.getTipo());
    }
}

