package logica;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<ProductoFactura> productos; 

    public Factura(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProductoFactura> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoFactura> productos) {
        this.productos = productos;
    }
   
    public void agregarProducto(Producto producto, int cantidad) {
        productos.add(new ProductoFactura(producto, cantidad));
    }

   
    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(pf -> pf.getProducto().getPrecio() * pf.getCantidad())
                .sum();
    }
    
   
    public BigDecimal calcularDescuento() {
        double total = calcularTotal();
        switch (cliente.getTipo()) {
            case "bronze":
                return total > 100 ? BigDecimal.valueOf(0.05).multiply(BigDecimal.valueOf(total)) : BigDecimal.ZERO;
            case "plata":
                return total > 300 ? BigDecimal.valueOf(0.15).multiply(BigDecimal.valueOf(total)) : BigDecimal.ZERO;
            case "oro":
                return total > 500 ? BigDecimal.valueOf(0.25).multiply(BigDecimal.valueOf(total)) : BigDecimal.ZERO;
            default:
                return BigDecimal.ZERO;
        }
    }
    
    
    public static class ProductoFactura {
        private Producto producto;
        private int cantidad;

        public ProductoFactura(Producto producto, int cantidad) {
            this.producto = producto;
            this.cantidad = cantidad;
        }

        // Getters y Setters
        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}
