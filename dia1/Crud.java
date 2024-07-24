package crud;

import java.util.Scanner;

public class Crud {
    public static void main(String[] args) {
        CamperCrud camperCrud = new CamperCrud(20);
        TrainerCrud trainerCrud = new TrainerCrud(10); 
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENU:");
            System.out.println("1. Crear Camper");
            System.out.println("2. Leer Campers");
            System.out.println("3. Actualizar Camper");
            System.out.println("4. Eliminar Camper");
            System.out.println("5. Ingresar Notas de Prueba Inicial");
            System.out.println("6. Crear Trainer");
            System.out.println("7. Modificar Jornada de Trainer");
            System.out.println("8. Leer Trainers");
            System.out.println("9. Actualizar Trainer");
            System.out.println("10. Eliminar Trainer");
            System.out.println("11. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Introduce los datos del camper:");
                    System.out.print("Número de documento: ");
                    int n_documento = scanner.nextInt();
                    scanner.nextLine(); 
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
                    scanner.nextLine(); 
                    System.out.print("Número fijo: ");
                    int n_fijo = scanner.nextInt();
                    scanner.nextLine(); 

                    camperCrud.crearCamper(n_documento, nombre, nombre2, apellido, apellido2, ciudad, direccion, acudiente, n_celular, n_fijo);
                    break;

                case 2:
                    System.out.println("Lista de campers:");
                    camperCrud.leerCamper();
                    break;

                case 3:
                    System.out.print("Introduce el ID del camper a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Introduce los nuevos datos del camper:");
                    System.out.print("Número de documento: ");
                    n_documento = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Segundo nombre: ");
                    String nombre2Actualizar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoActualizar = scanner.nextLine();
                    System.out.print("Segundo apellido: ");
                    String apellido2Actualizar = scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudadActualizar = scanner.nextLine();
                    System.out.print("Dirección: ");
                    String direccionActualizar = scanner.nextLine();
                    System.out.print("Acudiente: ");
                    String acudienteActualizar = scanner.nextLine();
                    System.out.print("Número de celular: ");
                    n_celular = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Número fijo: ");
                    n_fijo = scanner.nextInt();
                    scanner.nextLine(); 

                    camperCrud.actualizarCamper(idActualizar, n_documento, nombre, nombre2Actualizar, apellidoActualizar, apellido2Actualizar, ciudadActualizar, direccionActualizar, acudienteActualizar, n_celular, n_fijo);
                    break;

                case 4:
                    System.out.print("Introduce el ID del camper a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine(); 

                    if (camperCrud.eliminarCamper(idEliminar)) {
                        System.out.println("Camper eliminado correctamente.");
                    } else {
                        System.out.println("Camper con ID " + idEliminar + " no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Introduce el ID del camper para ingresar notas: ");
                    int idNotas = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Ingrese la nota práctica de la prueba inicial: ");
                    int notaPractica = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Ingrese la nota teórica de la prueba inicial: ");
                    int notaTeorica = scanner.nextInt();
                    scanner.nextLine(); 

                    if (camperCrud.ingresarNotas(idNotas, notaPractica, notaTeorica)) {
                        System.out.println("Notas ingresadas correctamente.");
                    } else {
                        System.out.println("Error al ingresar notas.");
                    }
                    break;

                case 6:
                    System.out.println("Introduce los datos del trainer:");
                    System.out.print("Número de documento: ");
                    int n_documento_trainer = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nombre: ");
                    String nombre_trainer = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido_trainer = scanner.nextLine();
                    System.out.print("Número de celular: ");
                    int n_celular_trainer = scanner.nextInt();
                    scanner.nextLine();

                    trainerCrud.crearTrainer(n_documento_trainer, nombre_trainer, apellido_trainer, n_celular_trainer);
                    break;

                case 7:
                    trainerCrud.modificarJornada();
                    break;

                case 8:
                    System.out.println("Lista de trainers:");
                    trainerCrud.leerTrainer();
                    break;

                case 9:
                    System.out.print("Introduce el ID del trainer a actualizar: ");
                    int idActualizarTrainer = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce los nuevos datos del trainer:");
                    System.out.print("Número de documento: ");
                    int n_documentoActualizar = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Nombre: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidotrainerActualizar = scanner.nextLine();
                    System.out.print("Número de celular: ");
                    int n_celularActualizar = scanner.nextInt();
                    scanner.nextLine(); 

                    trainerCrud.actualizarTrainer(idActualizarTrainer, n_documentoActualizar, nombreActualizar, apellidotrainerActualizar, n_celularActualizar);
                    break;

                case 10:
                    System.out.print("Introduce el ID del trainer a eliminar: ");
                    int idEliminarTrainer = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (trainerCrud.eliminarTrainer(idEliminarTrainer)) {
                        System.out.println("Trainer eliminado correctamente.");
                    } else {
                        System.out.println("Trainer con ID " + idEliminarTrainer + " no encontrado.");
                    }
                    break;

                case 11:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 11);

        scanner.close();
    }
}
