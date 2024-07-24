/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.util.Scanner;
/**
 *
 * @author pc1
 */
public class Salones {
    private static int opcion;  
    
    public static void main(String[] args) {
        menuRutas();
        menuAreas();
    }

    public static void menuRutas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nRutas disponibles:");
        System.out.println("1. Ruta NodeJS");
        System.out.println("2. Ruta Java");
        System.out.println("3. Ruta NetCore");
        
        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();  
        procesarOpcionRutas();

        scanner.close();
    }

    public static void menuAreas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nÁreas de entrenamiento disponibles:");
        System.out.println("1. Sputnik");
        System.out.println("2. Artemis");
        System.out.println("3. Apolo");
        
        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        procesarOpcionAreas();

        scanner.close();
    }

    public static void procesarOpcionRutas() {
        switch(opcion) {
            case 1:
                System.out.println("Has seleccionado la Ruta NodeJS.");
                break;
            case 2:
                System.out.println("Has seleccionado la Ruta Java.");
                break;
            case 3:
                System.out.println("Has seleccionado la Ruta NetCore.");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;
        }
    }

    public static void procesarOpcionAreas() {
        switch(opcion) {
            case 1:
                System.out.println("Has seleccionado el área Sputnik.");
                break;
            case 2:
                System.out.println("Has seleccionado el área Artemis.");
                break;
            case 3:
                System.out.println("Has seleccionado el área Apolo.");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;
        }
    }
}

