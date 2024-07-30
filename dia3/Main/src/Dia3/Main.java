package Dia3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalDAO hospitalDAO = new HospitalDAO();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== CRUD Hospital ===");
            System.out.println("1. Agregar hospital");
            System.out.println("2. Ver hospital");
            System.out.println("3. Ver todos los hospitales");
            System.out.println("4. Actualizar hospital");
            System.out.println("5. Eliminar hospital");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Nombre del hospital: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Dirección del hospital: ");
                    String direccion = scanner.nextLine();

                    Hospital nuevoHospital = new Hospital();
                    nuevoHospital.setNombre(nombre);
                    nuevoHospital.setDireccion(direccion);

                    hospitalDAO.addHospital(nuevoHospital);
                    break;

                case 2:
                    System.out.print("ID del hospital: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Hospital hospital = hospitalDAO.getHospital(id);
                    if (hospital != null) {
                        System.out.println("ID: " + hospital.getId_hospital());
                        System.out.println("Nombre: " + hospital.getNombre());
                        System.out.println("Dirección: " + hospital.getDireccion());
                    } else {
                        System.out.println("Hospital no encontrado");
                    }
                    break;

                case 3:
                    System.out.println("=== Lista de hospitales ===");
                    for (Hospital h : hospitalDAO.getAllHospitals()) {
                        System.out.println("ID: " + h.getId_hospital() + ", Nombre: " + h.getNombre() + ", Dirección: " + h.getDireccion());
                    }
                    break;

                case 4:
                    System.out.print("ID del hospital a actualizar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Hospital hospitalUpdate = hospitalDAO.getHospital(idUpdate);
                    if (hospitalUpdate != null) {
                        System.out.print("Nuevo nombre del hospital: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Nueva dirección del hospital: ");
                        String nuevaDireccion = scanner.nextLine();

                        hospitalUpdate.setNombre(nuevoNombre);
                        hospitalUpdate.setDireccion(nuevaDireccion);

                        hospitalDAO.updateHospital(hospitalUpdate);
                    } else {
                        System.out.println("Hospital no encontrado");
                    }
                    break;

                case 5:
                    System.out.print("ID del hospital a eliminar: ");
                    int idDelete = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    hospitalDAO.deleteHospital(idDelete);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (option != 6);

        scanner.close();
    }
}
