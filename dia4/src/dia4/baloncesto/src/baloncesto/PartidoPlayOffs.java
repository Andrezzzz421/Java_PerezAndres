/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartidoPlayOffs {
    private int idPartido;
    private String ronda; // 'octavos', 'cuartos', 'semifinal', 'final'

    // Constructor
    public PartidoPlayOffs(int idPartido, String ronda) {
        this.idPartido = idPartido;
        this.ronda = ronda;
    }

    public void guardarEnBaseDeDatos(Connection con) throws SQLException {
        String query = "INSERT INTO PartidoPlayOffs (id_partido, ronda) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idPartido);
            ps.setString(2, ronda);
            ps.executeUpdate();
        }
    }
}



