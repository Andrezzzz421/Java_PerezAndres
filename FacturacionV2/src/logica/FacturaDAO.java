package logica;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    private Connection con;

    public FacturaDAO(Connection con) {
        this.con = con;
    }

    public void agregarFactura(Factura factura) throws SQLException {
        String query = "INSERT INTO facturas (id_cliente, total, descuento_aplicado) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, factura.getCliente().getId());

            // Calcula el total de la factura
            BigDecimal total = BigDecimal.valueOf(factura.calcularTotal());
            stmt.setBigDecimal(2, total);

            // Calcula el descuento aplicado
            BigDecimal descuento = factura.calcularDescuento();
            stmt.setBigDecimal(3, descuento);

            // Ejecuta la actualización
            stmt.executeUpdate();

            // Obtiene la clave primaria generada
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    factura.setId(generatedKeys.getInt(1)); // Asigna el ID generado a la factura
                }
            }
        }
    }

    public void agregarProductoAFactura(int idFactura, Producto producto, int cantidad) throws SQLException {
        String query = "INSERT INTO factura_productos (id_factura, id_producto, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idFactura);
            stmt.setInt(2, producto.getId());
            stmt.setInt(3, cantidad);
            stmt.executeUpdate();
        }
    }

    public List<Producto> obtenerProductosDeFactura(int idFactura) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT p.id_producto, p.nombre, p.precio, fp.cantidad FROM productos p " +
                "JOIN factura_productos fp ON p.id_producto = fp.id_producto WHERE fp.id_factura = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idFactura);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto(
                            rs.getInt("id_producto"),
                            rs.getString("nombre"),
                            rs.getBigDecimal("precio").doubleValue(),
                            rs.getInt("cantidad")
                    );
                    productos.add(producto);
                }
            }
        }
        return productos;
    }

    public Cliente obtenerClienteDeFactura(int idFactura) throws SQLException {
        String query = "SELECT c.id_cliente, c.nombre, c.tipo_cliente FROM clientes c " +
                "JOIN facturas f ON c.id_cliente = f.id_cliente WHERE f.id_factura = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idFactura);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("id_cliente"),
                            rs.getString("nombre"),
                            rs.getString("tipo_cliente")
                    );
                }
            }
        }
        return null;
    }
}
