/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

/**
 *
 * @author pc1
 */
class DVDPlayer {
    public void turnOn() {
        System.out.println("DVD Player is now ON");
    }

    public void turnOff() {
        System.out.println("DVD Player is now OFF");
    }

    public void play(String movie) {
        System.out.println("DVD Player is now playing " + movie);
    }
}

