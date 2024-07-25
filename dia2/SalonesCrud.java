/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

/**
 *
 * @author camper
 */
public class SalonesCrud {
    private final Salones[] Salon;
    private int contador;

    public SalonesCrud(int cantidad) {
        this.Salon = new Salones[cantidad];
        this.contador = 0;
    }

    public void crearSalones(String nombregrupo, int fechainicio, int fechafinal) {
        if (contador < Salon.length) {
            Salon[contador++] = new Salones(nombregrupo, fechainicio, fechafinal);
            System.out.println("Salón creado exitosamente.");
        } else {
            System.out.println("Array lleno, no se puede ingresar más datos.");
        }
    }

    public void leerSalones() {
        if (contador == 0) {
            System.out.println("No hay salones registrados.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(Salon[i]);
            }
        }
    }
}

