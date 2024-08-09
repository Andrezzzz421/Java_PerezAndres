/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Builder;

/**
 *
 * @author pc1
 */
class Pizza {
    private String masa;
    private String salsa;
    private String relleno;

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public void mostrar() {
        System.out.println("Pizza con masa: " + masa + ", salsa: " + salsa + ", relleno: " + relleno);
    }
}

