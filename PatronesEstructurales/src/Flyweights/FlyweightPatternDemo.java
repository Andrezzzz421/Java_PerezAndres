/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Flyweights;

/**
 *
 * @author pc1
 */
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        Forest forest = new Forest();

        // Plantar árboles en el bosque
        forest.plantTree("Oak", 10, 20);
        forest.plantTree("Pine", 15, 25);
        forest.plantTree("Oak", 20, 30);
        forest.plantTree("Pine", 25, 35);

        // Verificar que los árboles de tipo 'Oak' y 'Pine' son reutilizados
    }
}
