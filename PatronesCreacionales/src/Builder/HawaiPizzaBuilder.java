/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author pc1
 */
class HawaiPizzaBuilder extends PizzaBuilder {
    public void construirMasa() {
        pizza.setMasa("suave");
    }
    public void construirSalsa() {
        pizza.setSalsa("dulce");
    }
    public void construirRelleno() {
        pizza.setRelleno("piña+jamón");
    }
}
