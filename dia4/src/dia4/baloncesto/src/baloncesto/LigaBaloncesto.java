package baloncesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LigaBaloncesto {
    private static Scanner scanner = new Scanner(System.in);
    private static Conection dbConnection = new Conection();
    private Resultado resultadoManager = new Resultado();

    public static void main(String[] args) {
        boolean continuar = true;
        LigaBaloncesto liga = new LigaBaloncesto(); // Crear una instancia de LigaBaloncesto

        while (continuar) {
            System.out.println("1. Registrar Equipo");
            System.out.println("2. Registrar Partido");
            System.out.println("3. Registrar Partido de Liga");
            System.out.println("4. Registrar Partido de PlayOffs");
            System.out.println("5. Registrar Puntos del Equipo Local");
            System.out.println("6. Registrar Puntos del Equipo Visitante");
            System.out.println("7. Finalizar Partido");
            System.out.println("8. Mostrar Información del Partido");
            System.out.println("9. Mostrar ");
            System.out.println("10. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    registrarEquipo();
                    break;
                case 2:
                    registrarPartido();
                    break;
                case 3:
                    registrarPartidoLiga();
                    break;
                case 4:
                    registrarPartidoPlayOffs();
                    break;
                case 5:
                    registrarPuntosLocal();
                    break;
                case 6:
                    registrarPuntosVisitante();
                    break;
                case 7:
                    finalizarPartido();
                    break;
                case 8:
                    mostrarInformacionPartido();
                    break;
                case 9:
                    mostrarGanador();
                case 10:
                    continuar = false;
                    dbConnection.closeConnection();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void registrarEquipo() {
        System.out.println("Ingrese el nombre del equipo:");
        String nombre = scanner.nextLine();

        Equipo equipo = new Equipo(nombre);

        try (Connection con = dbConnection.getConnection()) {
            if (con != null) {
                equipo.guardarEnBaseDeDatos(con);
                System.out.println("Equipo registrado exitosamente con ID: " + equipo.getIdEquipo());
            } else {
                System.err.println("La conexión a la base de datos es nula.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void registrarPartido() {
        System.out.println("Ingrese el ID del equipo local:");
        int equipoLocalId = scanner.nextInt();
        System.out.println("Ingrese el ID del equipo visitante:");
        int equipoVisitanteId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese la fecha del partido (YYYY-MM-DD):");
        String fecha = scanner.nextLine();
        System.out.println("Ingrese el tipo de partido (liga/playoffs):");
        String tipoPartido = scanner.nextLine();

        String query = "INSERT INTO Partido (equipo_local, equipo_visitante, fecha, tipo_partido) VALUES (?, ?, ?, ?)";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, equipoLocalId);
            ps.setInt(2, equipoVisitanteId);
            ps.setString(3, fecha);
            ps.setString(4, tipoPartido);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idPartido = rs.getInt(1);
                System.out.println("Partido registrado exitosamente con ID: " + idPartido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  private static void registrarPartidoLiga() {
    System.out.println("Ingrese el ID del partido:");
    int idPartido = scanner.nextInt();
    System.out.println("Ingrese la jornada:");
    int jornada = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea

    String query = "INSERT INTO PartidoLiga (id_partido, jornada) VALUES (?, ?)";

    try (Connection con = dbConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {

        // Verificar si la conexión es válida
        if (con != null && !con.isClosed()) {
            ps.setInt(1, idPartido);
            ps.setInt(2, jornada);
            ps.executeUpdate();
            System.out.println("Detalles de partido de liga registrados exitosamente.");
        } else {
            System.err.println("La conexión a la base de datos está cerrada.");
        }
    } catch (SQLException e) {
        System.err.println("Error SQL al registrar el partido de liga: " + e.getMessage());
        e.printStackTrace();
    }
}

    private static void registrarPartidoPlayOffs() {
        System.out.println("Ingrese el ID del partido:");
        int idPartido = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Ingrese la ronda (octavos, cuartos, semifinal, final):");
        String ronda = scanner.nextLine();

        String query = "INSERT INTO PartidoPlayOffs (id_partido, ronda) VALUES (?, ?)";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idPartido);
            ps.setString(2, ronda);
            ps.executeUpdate();
            System.out.println("Detalles de partido de playoffs registrados exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void registrarPuntosLocal() {
        System.out.println("Ingrese el ID del partido:");
        int idPartido = scanner.nextInt();
        System.out.println("Ingrese los puntos del equipo local:");
        int puntos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        String query = "UPDATE Partido SET cestas_local = ? WHERE id_partido = ?";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, puntos);
            ps.setInt(2, idPartido);
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Puntos del equipo local actualizados exitosamente.");
            } else {
                System.out.println("No se encontró el partido con el ID proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void registrarPuntosVisitante() {
        System.out.println("Ingrese el ID del partido:");
        int idPartido = scanner.nextInt();
        System.out.println("Ingrese los puntos del equipo visitante:");
        int puntos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        String query = "UPDATE Partido SET cestas_visitante = ? WHERE id_partido = ?";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, puntos);
            ps.setInt(2, idPartido);
            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Puntos del equipo visitante actualizados exitosamente.");
            } else {
                System.out.println("No se encontró el partido con el ID proporcionado o no se actualizó ninguna fila.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

private static void finalizarPartido() {
    System.out.println("Ingrese el ID del partido:");
    int idPartido = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea

    String updateQuery = "UPDATE Partido SET finalizado = TRUE WHERE id_partido = ?";
    String selectQuery = "SELECT equipo_local, equipo_visitante, cestas_local, cestas_visitante FROM Partido WHERE id_partido = ?";
    String insertResultadoQuery = "INSERT INTO Resultado (id_partido, ganador) VALUES (?, ?)";

    try (Connection con = dbConnection.getConnection();
         PreparedStatement updatePs = con.prepareStatement(updateQuery);
         PreparedStatement selectPs = con.prepareStatement(selectQuery);
         PreparedStatement insertPs = con.prepareStatement(insertResultadoQuery)) {

        // Marcar el partido como finalizado
        updatePs.setInt(1, idPartido);
        int filasActualizadas = updatePs.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Partido finalizado exitosamente.");

            // Obtener el resultado del partido
            selectPs.setInt(1, idPartido);
            ResultSet rs = selectPs.executeQuery();

            if (rs.next()) {
                int equipoLocalId = rs.getInt("equipo_local");
                int equipoVisitanteId = rs.getInt("equipo_visitante");
                int cestasLocal = rs.getInt("cestas_local");
                int cestasVisitante = rs.getInt("cestas_visitante");

                int ganador;
                if (cestasLocal > cestasVisitante) {
                    ganador = equipoLocalId;
                } else if (cestasVisitante > cestasLocal) {
                    ganador = equipoVisitanteId;
                } else {
                    ganador = -1; // En caso de empate, puedes decidir qué hacer
                    System.out.println("El partido terminó en empate.");
                }

                if (ganador != -1) {
                    // Registrar el ganador
                    insertPs.setInt(1, idPartido);
                    insertPs.setInt(2, ganador);
                    insertPs.executeUpdate();
                    System.out.println("Ganador registrado exitosamente.");
                }
            } else {
                System.out.println("No se encontró información para el ID del partido proporcionado.");
            }
        } else {
            System.out.println("No se encontró el partido con el ID proporcionado o no se actualizó ninguna fila.");
        }
    } catch (SQLException e) {
        System.err.println("Error SQL al finalizar el partido: " + e.getMessage());
        e.printStackTrace();
    }
}

    private static void mostrarInformacionPartido() {
        System.out.println("Ingrese el ID del partido:");
        int idPartido = scanner.nextInt();

        String query = "SELECT * FROM Partido WHERE id_partido = ?";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID Partido: " + rs.getInt("id_partido"));
                System.out.println("Equipo Local: " + rs.getInt("equipo_local"));
                System.out.println("Equipo Visitante: " + rs.getInt("equipo_visitante"));
                System.out.println("Fecha: " + rs.getDate("fecha"));
                System.out.println("Tipo de Partido: " + rs.getString("tipo_partido"));
                System.out.println("Cestas Local: " + rs.getInt("cestas_local"));
                System.out.println("Cestas Visitante: " + rs.getInt("cestas_visitante"));
                System.out.println("Finalizado: " + rs.getBoolean("finalizado"));
            } else {
                System.out.println("No se encontró información para el ID del partido proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void mostrarGanador() {
    System.out.println("Ingrese el ID del partido:");
    int idPartido = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea

    String query = "SELECT ganador FROM Resultado WHERE id_partido = ?";

    try (Connection con = dbConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setInt(1, idPartido);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int ganadorId = rs.getInt("ganador");
            System.out.println("El ganador del partido con ID " + idPartido + " es el equipo con ID: " + ganadorId);
        } else {
            System.out.println("No se encontró el resultado para el ID del partido proporcionado.");
        }
    } catch (SQLException e) {
        System.err.println("Error SQL al obtener el ganador: " + e.getMessage());
        e.printStackTrace();
    }
}

    
}
