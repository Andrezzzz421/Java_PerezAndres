/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

/**
 *
 * @author pc1
 */
class SoundSystem {
    public void turnOn() {
        System.out.println("Sound System is now ON");
    }

    public void turnOff() {
        System.out.println("Sound System is now OFF");
    }

    public void setVolume(int volume) {
        System.out.println("Sound System volume set to " + volume);
    }
}