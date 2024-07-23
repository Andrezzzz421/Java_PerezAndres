package crud;

import java.util.Scanner;

public class Crud {

    public static void main(String[] args) {
        CamperCrud camperCrud = new CamperCrud(20);
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Crear Camper");
            System.out.println("2. Leer Campers");
            System.out.println("3. Actualizar Camper");
            System.out.println("4. Eliminar Camper");
            System.out.println("5. Ingresar Notas de Prueba Inicial");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcion) {
                case 1:
                    System.out.println("Introduce los datos del camper:");
                    System.out.print("Número de documento: ");
                    int n_documento = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Segundo nombre: ");
                    String nombre2 = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Segundo apellido: ");
                    String apellido2 = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Acudiente: ");
                    String acudiente = scanner.nextLine();
                    System.out.print("Número de celular: ");
                    int n_celular = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Número fijo: ");
                    int n_fijo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    camperCrud.crearCamper(n_documento, nombre, nombre2, apellido, apellido2, ciudad, direccion, acudiente, n_celular, n_fijo);
                    break;

                case 2:
                    System.out.println("Lista de campers:");
                    camperCrud.leerCamper();
                    break;

                case 3:
                    System.out.print("Introduce el ID del camper a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Introduce los nuevos datos del camper:");
                    System.out.print("Número de documento: ");
                    n_documento = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Segundo nombre: ");
                    nombre2 = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Segundo apellido: ");
                    apellido2 = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    ciudad = scanner.nextLine();
                    System.out.print("Dirección: ");
                    direccion = scanner.nextLine();
                    System.out.print("Acudiente: ");
                    acudiente = scanner.nextLine();
                    System.out.print("Número de celular: ");
                    n_celular = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Número fijo: ");
                    n_fijo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    camperCrud.actualizarCamper(idActualizar, n_documento, nombre, nombre2, apellido, apellido2, ciudad, direccion, acudiente, n_celular, n_fijo);
                    break;

                case 4:
                    System.out.print("Introduce el ID del camper a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (camperCrud.eliminarCamper(idEliminar)) {
                        System.out.println("Camper eliminado correctamente.");
                    } else {
                        System.out.println("Camper con ID " + idEliminar + " no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Introduce el ID del camper para ingresar notas: ");
                    int idNotas = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Ingrese la nota práctica de la prueba inicial: ");
                    int notaPractica = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Ingrese la nota teórica de la prueba inicial: ");
                    int notaTeorica = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (camperCrud.ingresarNotas(idNotas, notaPractica, notaTeorica)) {
                        System.out.println("Notas ingresadas correctamente.");
                    } else {
                        System.out.println("Error al ingresar notas.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
    }
}
