/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Builder;

/**
 *
 * @author pc1
 */
public class Main {
    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        PizzaBuilder hawaiPizzaBuilder = new HawaiPizzaBuilder();
        PizzaBuilder picantePizzaBuilder = new PicantePizzaBuilder();

        cocina.setPizzaBuilder(hawaiPizzaBuilder);
        cocina.construirPizza();
        Pizza pizza1 = cocina.getPizza();
        pizza1.mostrar();

        cocina.setPizzaBuilder(picantePizzaBuilder);
        cocina.construirPizza();
        Pizza pizza2 = cocina.getPizza();
        pizza2.mostrar();
    }
}

