/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ChainofResponsibility;

/**
 *
 * @author camper
 */
public class ChainOfResponsibilityPatternDemo {
    public static void main(String[] args) {
        SupportHandler lowLevel = new LowLevelSupport();
        SupportHandler midLevel = new MidLevelSupport();
        SupportHandler highLevel = new HighLevelSupport();

        lowLevel.setNextHandler(midLevel);
        midLevel.setNextHandler(highLevel);

        // Simulación de solicitudes
        lowLevel.handleRequest("LowLevelIssue");
        lowLevel.handleRequest("MidLevelIssue");
        lowLevel.handleRequest("HighLevelIssue");
        lowLevel.handleRequest("UnknownIssue");
    }
}
