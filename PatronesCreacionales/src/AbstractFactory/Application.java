/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AbstractFactory;

public class Application {
    private Boton boton;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        boton = factory.crearBoton();
        checkBox = factory.crearCheckBox();
    }

    public void pintar() {
        boton.pintar();
        checkBox.marcar();
    }

    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        Application app = new Application(factory);
        app.pintar();
    }
}
