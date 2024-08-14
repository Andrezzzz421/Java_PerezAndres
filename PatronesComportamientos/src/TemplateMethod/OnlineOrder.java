/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

/**
 *
 * @author camper
 */
class OnlineOrder extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Product selected from online store.");
    }

    @Override
    protected void makePayment() {
        System.out.println("Payment made through online payment gateway.");
    }

    @Override
    protected void deliverProduct() {
        System.out.println("Product delivered via courier.");
    }
}