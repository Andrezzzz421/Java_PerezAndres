package baloncesto;

import java.sql.*;

public class Equipo {
    private String nombre;
    private int idEquipo;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public void guardarEnBaseDeDatos(Connection con) throws SQLException {
        String sql = "INSERT INTO Equipo (nombre) VALUES (?)";
        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nombre);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        this.idEquipo = rs.getInt(1);
                    }
                }
            } else {
                throw new SQLException("No se pudo obtener la clave generada.");
            }
        }
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }
}
