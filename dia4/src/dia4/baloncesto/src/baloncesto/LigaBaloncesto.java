/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

import java.util.Scanner;

/**
 *
 * @author pc1
 */
public class LigaBaloncesto {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Partido partido = null;
        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Registrar Partido de Liga");
            System.out.println("2. Registrar Partido de PlayOffs");
            System.out.println("3. Finalizar Partido");
            System.out.println("4. Mostrar Información del Partido");
            System.out.println("5. Mostrar Ganador");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (opcion) {
                case 1:
                    partido = registrarPartidoLiga();
                    break;
                case 2:
                    partido = registrarPartidoPlayOffs();
                    break;
                case 3:
                    if (partido != null) {
                        partido.finalizarPartido();
                    } else {
                        System.out.println("No hay partido registrado.");
                    }
                    break;
                case 4:
                    if (partido != null) {
                        System.out.println(partido.obtenerInformacion());
                    } else {
                        System.out.println("No hay partido registrado.");
                    }
                    break;
                case 5:
                    if (partido != null) {
                        System.out.println("Ganador: " + partido.obtenerGanador());
                    } else {
                        System.out.println("No hay partido registrado.");
                    }
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static PartidoLiga registrarPartidoLiga() {
        System.out.println("Ingrese equipo local:");
        String equipoLocal = scanner.nextLine();
        System.out.println("Ingrese equipo visitante:");
        String equipoVisitante = scanner.nextLine();
        System.out.println("Ingrese fecha del partido:");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese número de jornada:");
        int jornada = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        PartidoLiga partido = new PartidoLiga(equipoLocal, equipoVisitante, fecha, jornada);
        System.out.println("Partido de Liga registrado.");
        return partido;
    }

    private static PartidoPlayOffs registrarPartidoPlayOffs() {
        System.out.println("Ingrese equipo local:");
        String equipoLocal = scanner.nextLine();
        System.out.println("Ingrese equipo visitante:");
        String equipoVisitante = scanner.nextLine();
        System.out.println("Ingrese fecha del partido:");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese ronda (e.g., octavos, cuartos, final):");
        String ronda = scanner.nextLine();

        PartidoPlayOffs partido = new PartidoPlayOffs(equipoLocal, equipoVisitante, fecha, ronda);
        System.out.println("Partido de PlayOffs registrado.");
        return partido;
    }
}

