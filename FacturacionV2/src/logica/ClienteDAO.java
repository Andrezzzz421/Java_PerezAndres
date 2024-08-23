/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }

    // Agregar un cliente a la base de datos
    public void agregarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO clientes (nombre, tipo_cliente) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getTipo());
            stmt.executeUpdate();
        }
    }

    // Obtener un cliente por su ID
    public Cliente obtenerClientePorId(int id) throws SQLException {
        String query = "SELECT * FROM clientes WHERE id_cliente = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("tipo")
                    );
                }
            }
        }
        return null;
    }
}
