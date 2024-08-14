/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TemplateMethod;

/**
 *
 * @author camper
 */
public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        OrderProcessTemplate order = new OnlineOrder();
        order.processOrder();
    }
}