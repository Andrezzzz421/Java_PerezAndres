/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package State;

/**
 *
 * @author camper
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        NetworkContext context = new NetworkContext();

        context.request(); // Estado: Desconectado -> Conectado
        context.request(); // Estado: Conectado -> Desconectado
    }
}