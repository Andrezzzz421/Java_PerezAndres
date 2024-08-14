/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Command;

/**
 *
 * @author camper
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();

        // Añadir texto al documento
        Command addText1 = new AddTextCommand(editor.document, "Hello, ");
        editor.executeCommand(addText1);

        Command addText2 = new AddTextCommand(editor.document, "World!");
        editor.executeCommand(addText2);

        editor.printDocument(); // Salida: Hello, World!

        // Deshacer la última operación
        editor.undo();
        editor.printDocument(); // Salida: Hello,
    }
}