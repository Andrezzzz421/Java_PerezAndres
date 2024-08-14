/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

/**
 *
 * @author pc1
 */
class Television {
    public void turnOn() {
        System.out.println("Television is now ON");
    }

    public void turnOff() {
        System.out.println("Television is now OFF");
    }

    public void setInput(String input) {
        System.out.println("Television input set to " + input);
    }
}