/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import Conection.Conection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import logica.Cliente;
import logica.ClienteDAO;
import logica.Factura;
import logica.FacturaDAO;
import logica.Producto;
import logica.ProductoDAO;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Connection con = new Conection().getConnection();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        ProductoDAO productoDAO = new ProductoDAO(con);
        FacturaDAO facturaDAO = new FacturaDAO(con);

        boolean running = true;
        while (running) {
            System.out.println("Menú:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Producto");
            System.out.println("3. Crear Factura");
            System.out.println("4. Agregar Producto a Factura");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    agregarCliente(clienteDAO);
                    break;
                case 2:
                    agregarProducto(productoDAO);
                    break;
                case 3:
                    crearFactura(facturaDAO, clienteDAO);
                    break;
                case 4:
                    agregarProductoAFactura(facturaDAO, productoDAO);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        // Cerrar conexión
        new Conection().closeConnection();
    }

    private static void agregarCliente(ClienteDAO clienteDAO) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el tipo del cliente (bronze, plata, oro): ");
        String tipo = scanner.nextLine();

        Cliente cliente = new Cliente(0, nombre, tipo);
        try {
            clienteDAO.agregarCliente(cliente);
            System.out.println("Cliente agregado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    private static void agregarProducto(ProductoDAO productoDAO) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        Producto producto = new Producto(0, nombre, precio, cantidad);
        try {
            productoDAO.agregarProducto(producto);
            System.out.println("Producto agregado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar producto: " + e.getMessage());
        }
    }

    private static void crearFactura(FacturaDAO facturaDAO, ClienteDAO clienteDAO) {
        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        try {
            Cliente cliente = clienteDAO.obtenerClientePorId(idCliente);
            if (cliente != null) {
                Factura factura = new Factura(0, cliente);
                facturaDAO.agregarFactura(factura);
                System.out.println("Factura creada exitosamente. ID de factura: " + factura.getId());
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al crear factura: " + e.getMessage());
        }
    }

    private static void agregarProductoAFactura(FacturaDAO facturaDAO, ProductoDAO productoDAO) {
        System.out.print("Ingrese el ID de la factura: ");
        int idFactura = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        System.out.print("Ingrese el ID del producto: ");
        int idProducto = scanner.nextInt();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consumir la nueva línea

        try {
            Producto producto = productoDAO.obtenerProductoPorId(idProducto);
            if (producto != null) {
                facturaDAO.agregarProductoAFactura(idFactura, producto, cantidad);
                System.out.println("Producto agregado a la factura exitosamente.");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar producto a factura: " + e.getMessage());
        }
    }
}
