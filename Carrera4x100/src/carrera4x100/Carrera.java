package carrera4x100;

public class Carrera {
    public static final Object testigo = new Object();

    public static void main(String[] args) {
        
        Atleta atleta1 = new Atleta("Jair", 1);
        Atleta atleta2 = new Atleta("Brayan", 2);
        Atleta atleta3 = new Atleta("Clisma", 3);
        Atleta atleta4 = new Atleta("Josefina", 4);

        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();

        synchronized (Carrera.testigo) {
            Carrera.testigo.notify();
        }
    }
}

class Atleta extends Thread {
    private String nombre;
    private int numeroAtleta;

    public Atleta(String nombre, int numeroAtleta) {
        this.nombre = nombre;
        this.numeroAtleta = numeroAtleta;
    }

    @Override
    public void run() {
        try {
            synchronized (Carrera.testigo) {
                Carrera.testigo.wait(); 
            }
            int tiempoCarrera = (int) (Math.random() * 2000 + 9000); 
            System.out.println(nombre + " Va embalao");
            Thread.sleep(tiempoCarrera);
            System.out.println(nombre + " Se fue de jeta en " + (tiempoCarrera / 1000.0) + " segundos.");

            synchronized (Carrera.testigo) {
                Carrera.testigo.notify(); 
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
