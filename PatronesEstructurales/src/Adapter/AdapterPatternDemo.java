/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Adapter;

/**
 *
 * @author pc1
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        NewPaymentAPI newPaymentAPI = new NewPaymentAPI();
        PaymentProcessor paymentProcessor = new PaymentAdapter(newPaymentAPI);

        paymentProcessor.processPayment(150.0);
    }
}
