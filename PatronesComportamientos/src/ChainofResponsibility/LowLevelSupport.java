/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChainofResponsibility;

/**
 *
 * @author camper
 */
class LowLevelSupport extends SupportHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("LowLevelIssue")) {
            System.out.println("LowLevelSupport: Handling low-level issue.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
