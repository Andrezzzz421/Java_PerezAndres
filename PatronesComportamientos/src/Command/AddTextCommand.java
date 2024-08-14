/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author camper
 */
class AddTextCommand implements Command {
    private StringBuilder document;
    private String text;

    public AddTextCommand(StringBuilder document, String text) {
        this.document = document;
        this.text = text;
    }

    @Override
    public void execute() {
        document.append(text);
    }

    @Override
    public void undo() {
        document.delete(document.length() - text.length(), document.length());
    }
}
