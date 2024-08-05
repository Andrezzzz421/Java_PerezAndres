package baloncesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Resultado {
    private Conection dbConnection;

    public Resultado() {
        dbConnection = new Conection();
    }

    public void insertarResultado(int idPartido, int ganador) {
        String query = "INSERT INTO Resultado (id_partido, ganador) VALUES (?, ?)";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            if (con != null && !con.isClosed()) {
                ps.setInt(1, idPartido);
                ps.setInt(2, ganador);
                ps.executeUpdate();
                System.out.println("Resultado insertado correctamente.");
            } else {
                System.err.println("La conexión a la base de datos está cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al insertar resultado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(); // Cierra la conexión cuando ya no la necesites
        }
    }

    public void finalizarPartido(int idPartido) {
        String query = "SELECT equipo_local, equipo_visitante, cestas_local, cestas_visitante " +
                       "FROM Partido WHERE id_partido = ?";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            if (con != null && !con.isClosed()) {
                ps.setInt(1, idPartido);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int equipoLocal = rs.getInt("equipo_local");
                    int equipoVisitante = rs.getInt("equipo_visitante");
                    int cestasLocal = rs.getInt("cestas_local");
                    int cestasVisitante = rs.getInt("cestas_visitante");

                    int ganador = (cestasLocal > cestasVisitante) ? equipoLocal :
                                   (cestasVisitante > cestasLocal) ? equipoVisitante : -1;

                    insertarResultado(idPartido, ganador);

                    // Actualizar el partido como finalizado
                    String updateQuery = "UPDATE Partido SET finalizado = TRUE WHERE id_partido = ?";
                    try (PreparedStatement updatePs = con.prepareStatement(updateQuery)) {
                        updatePs.setInt(1, idPartido);
                        updatePs.executeUpdate();
                        System.out.println("Partido finalizado y resultado registrado.");
                    }
                } else {
                    System.out.println("No se encontró el partido con el ID proporcionado.");
                }
            } else {
                System.err.println("La conexión a la base de datos está cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al finalizar partido: " + e.getMessage());
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(); // Cierra la conexión cuando ya no la necesites
        }
    }

    public void obtenerGanador(int idPartido) {
        String query = "SELECT ganador FROM Resultado WHERE id_partido = ?";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            if (con != null && !con.isClosed()) {
                ps.setInt(1, idPartido);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int ganador = rs.getInt("ganador");

                    if (ganador == -1) {
                        System.out.println("El partido terminó en empate.");
                    } else {
                        System.out.println("Ganador: Equipo (ID: " + ganador + ")");
                    }
                } else {
                    System.out.println("No se encontró el resultado para el partido con el ID proporcionado.");
                }
            } else {
                System.err.println("La conexión a la base de datos está cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error SQL al obtener el ganador: " + e.getMessage());
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection(); // Cierra la conexión cuando ya no la necesites
        }
    }
}
