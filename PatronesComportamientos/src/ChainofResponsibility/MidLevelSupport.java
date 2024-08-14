/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChainofResponsibility;

/**
 *
 * @author camper
 */
class MidLevelSupport extends SupportHandler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("MidLevelIssue")) {
            System.out.println("MidLevelSupport: Handling mid-level issue.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
