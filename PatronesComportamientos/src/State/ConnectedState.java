/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

/**
 *
 * @author camper
 */
class ConnectedState implements NetworkState {
    @Override
    public void handle(NetworkContext context) {
        System.out.println("Network is connected.");
        context.setState(new DisconnectedState());
    }
}
