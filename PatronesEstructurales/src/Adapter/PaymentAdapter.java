/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author pc1
 */
class PaymentAdapter implements PaymentProcessor {
    private NewPaymentAPI newPaymentAPI;

    public PaymentAdapter(NewPaymentAPI newPaymentAPI) {
        this.newPaymentAPI = newPaymentAPI;
    }

    @Override
    public void processPayment(double amount) {
        // El adaptador convierte la llamada a la interfaz esperada
        newPaymentAPI.executePayment(amount);
    }
}
