/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FactoryMethod;

/**
 *
 * @author pc1
 */
class CreadorB extends Creador {
    Producto factoryMethod() {
        return new ProductoB();
    }
}

