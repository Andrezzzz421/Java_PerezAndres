/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author pc1
 */
class WindowsFactory implements GUIFactory {

    WindowsFactory() {
    }
    public Boton crearBoton() {
        return new WindowsBoton();
    }

    public CheckBox crearCheckBox() {
        return new WindowsCheckBox();
    }
}

