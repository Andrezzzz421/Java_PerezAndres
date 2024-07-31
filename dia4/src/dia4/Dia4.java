/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dia4;

/**
 *
 * @author camper
 */
public class Dia4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal();
        
        a1.setEdad(25);
        a1.setTipo("mamifero");
        
        a2.setEdad(30);
        a2.setTipo("Reptil");
        
        a1.caminar();
        a2.caminar();
        
    }
    
}
