/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author pc1
 */
class Cocina {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pb) {
        pizzaBuilder = pb;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void construirPizza() {
        pizzaBuilder.crearNuevaPizza();
        pizzaBuilder.construirMasa();
        pizzaBuilder.construirSalsa();
        pizzaBuilder.construirRelleno();
    }
}

