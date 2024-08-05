/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PartidoLiga {
    private int idPartido;
    private int jornada;

    // Constructor
    public PartidoLiga(int idPartido, int jornada) {
        this.idPartido = idPartido;
        this.jornada = jornada;
    }

    public void guardarEnBaseDeDatos(Connection con) throws SQLException {
        String query = "INSERT INTO PartidoLiga (id_partido, jornada) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idPartido);
            ps.setInt(2, jornada);
            ps.executeUpdate();
        }
    }
}



