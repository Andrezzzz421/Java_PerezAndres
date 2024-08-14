/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

/**
 *
 * @author camper
 */
abstract class OrderProcessTemplate {
    public final void processOrder() {
        selectProduct();
        makePayment();
        deliverProduct();
    }

    protected abstract void selectProduct();
    protected abstract void makePayment();
    protected abstract void deliverProduct();
}