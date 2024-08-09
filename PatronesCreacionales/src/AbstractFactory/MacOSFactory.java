/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author pc1
 */
class MacOSFactory implements GUIFactory {
    public Boton crearBoton() {
        return new MacOSBoton();
    }

    public CheckBox crearCheckBox() {
        return new MacOSCheckBox();
    }
}
