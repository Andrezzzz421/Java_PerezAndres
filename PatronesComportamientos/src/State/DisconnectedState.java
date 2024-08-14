/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

/**
 *
 * @author camper
 */
class DisconnectedState implements NetworkState {
    @Override
    public void handle(NetworkContext context) {
        System.out.println("Network is disconnected.");
        context.setState(new ConnectedState());
    }
}
