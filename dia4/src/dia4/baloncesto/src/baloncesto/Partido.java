package baloncesto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Partido {
    private int equipoLocalId;
    private int equipoVisitanteId;
    private String fecha; // Formato 'YYYY-MM-DD'
    private boolean finalizado;
    private String tipoPartido; // 'liga' o 'playoffs'

    // Constructor
    public Partido(int equipoLocalId, int equipoVisitanteId, String fecha, boolean finalizado, String tipoPartido) {
        this.equipoLocalId = equipoLocalId;
        this.equipoVisitanteId = equipoVisitanteId;
        this.fecha = fecha;
        this.finalizado = finalizado;
        this.tipoPartido = tipoPartido;
    }

    // Métodos getter y setter
    // ...

    public int guardarEnBaseDeDatos(Connection con) throws SQLException {
        String query = "INSERT INTO Partido (equipo_local, equipo_visitante, fecha, finalizado, tipo_partido) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, equipoLocalId);
            ps.setInt(2, equipoVisitanteId);
            ps.setDate(3, Date.valueOf(fecha)); // Convierte String a java.sql.Date
            ps.setBoolean(4, finalizado);
            ps.setString(5, tipoPartido);
            ps.executeUpdate();

            // Obtener el ID del partido insertado
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Devuelve el ID del nuevo partido
            } else {
                throw new SQLException("No se pudo obtener el ID del partido insertado.");
            }
        }
    }
}
