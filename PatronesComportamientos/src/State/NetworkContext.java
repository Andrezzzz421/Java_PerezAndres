/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

/**
 *
 * @author camper
 */
class NetworkContext {
    private NetworkState state;

    public NetworkContext() {
        state = new DisconnectedState(); // Estado inicial
    }

    public void setState(NetworkState state) {
        this.state = state;
    }

    public void request() {
        state.handle(this);
    }
}