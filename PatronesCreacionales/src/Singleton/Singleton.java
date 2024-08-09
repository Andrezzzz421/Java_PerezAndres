package Singleton;

public class Singleton {
    // Variable estática que mantiene la única instancia de la clase Singleton
    private static Singleton instanciaUnica;

    // Constructor privado para evitar que la clase sea instanciada desde fuera
    private Singleton() {
        // Código de inicialización
    }

    // Método público y estático que devuelve la única instancia de la clase
    public static Singleton getInstancia() {
        if (instanciaUnica == null) {
            // Si la instancia aún no ha sido creada, se crea aquí
            instanciaUnica = new Singleton();
        }
        return instanciaUnica;
    }

    // Otros métodos de la clase
    public void mostrarMensaje() {
        System.out.println("¡Hola! Soy la única instancia de Singleton.");
    }
}