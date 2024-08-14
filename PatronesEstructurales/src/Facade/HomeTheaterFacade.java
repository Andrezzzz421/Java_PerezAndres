/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

/**
 *
 * @author pc1
 */
class HomeTheaterFacade {
    private Television television;
    private SoundSystem soundSystem;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(Television tv, SoundSystem sound, DVDPlayer dvd) {
        this.television = tv;
        this.soundSystem = sound;
        this.dvdPlayer = dvd;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        television.turnOn();
        television.setInput("DVD");
        soundSystem.turnOn();
        soundSystem.setVolume(10);
        dvdPlayer.turnOn();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down...");
        dvdPlayer.turnOff();
        soundSystem.turnOff();
        television.turnOff();
    }
}