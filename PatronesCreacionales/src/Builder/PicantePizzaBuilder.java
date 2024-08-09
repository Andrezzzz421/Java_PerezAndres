/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author pc1
 */
class PicantePizzaBuilder extends PizzaBuilder {
    public void construirMasa() {
        pizza.setMasa("corteza fina");
    }
    public void construirSalsa() {
        pizza.setSalsa("picante");
    }
    public void construirRelleno() {
        pizza.setRelleno("pepperoni+salami");
    }
}

