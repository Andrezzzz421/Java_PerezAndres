/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prototype;

/**
 *
 * @author pc1
 */
abstract class Forma implements Cloneable {
    private String id;
    protected String tipo;

    abstract void dibujar();

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clonar() {
        Object clon = null;
        try {
            clon = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clon;
    }
}

