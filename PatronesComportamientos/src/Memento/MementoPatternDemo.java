/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Memento;

/**
 *
 * @author camper
 */
public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addText("Hello, ");
        TextMemento savedState1 = editor.save();

        editor.addText("World!");
        System.out.println("Current Text: " + editor.getText());

        editor.restore(savedState1);
        System.out.println("Restored Text: " + editor.getText());
    }
}