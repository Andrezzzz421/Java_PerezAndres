/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Observer;

/**
 *
 * @author camper
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsChannel channel1 = new NewsChannel();
        NewsChannel channel2 = new NewsChannel();

        newsAgency.addObserver(channel1);
        newsAgency.addObserver(channel2);

        newsAgency.setNews("Breaking News: Java Patterns are awesome!");
    }
}