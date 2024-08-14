/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Facade;

/**
 *
 * @author pc1
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        Television tv = new Television();
        SoundSystem sound = new SoundSystem();
        DVDPlayer dvd = new DVDPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, sound, dvd);

        // Usar la fachada para ver una película
        homeTheater.watchMovie("Inception");

        // Finalizar la visualización de la película
        homeTheater.endMovie();
    }
}
