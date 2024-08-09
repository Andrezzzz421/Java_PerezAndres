/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author pc1
 */
public class Main {
    public static void main(String[] args) {
        Creador creadorA = new CreadorA();
        creadorA.operacion();

        Creador creadorB = new CreadorB();
        creadorB.operacion();
    }
}
