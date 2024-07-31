/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dia4.Ejemplo3_polimorfismo;

/**
 *
 * @author camper
 */
public class Main {
    public static void main(String[] args) {
        // Creamos un array de Animal
        Animal[] animales = new Animal[3];
        animales[0] = new Perro();
        animales[1] = new Gato();
        animales[2] = new Animal();

        // Iteramos a través del array y llamamos al método hacerSonido
        for (Animal animal : animales) {
            animal.hacerSonido();
        }
    }
}
    
