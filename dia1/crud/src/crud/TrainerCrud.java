package crud;

import java.util.Scanner;

public class TrainerCrud {
    private Trainers[] trainers;
    private int contador;
    private int nextId; // ID autoincremental

    public TrainerCrud(int cantidad) {
        this.trainers = new Trainers[cantidad];
        this.contador = 0;
        this.nextId = 1; // Inicializa el ID con 1
    }

 
    public void crearTrainer(int n_documento, String nombre, String apellidotrainer, int n_celular) {
        if (contador < trainers.length) {
            trainers[contador++] = new Trainers(nextId++, n_documento, nombre, apellidotrainer, n_celular, "No asignado");
        } else {
            System.out.println("Array lleno, no se puede ingresar más datos");
        }
    }

    public boolean existeTrainer(int id) {
        for (int i = 0; i < contador; i++) {
            if (trainers[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Trainers obtenerTrainer(int id) {
        for (int i = 0; i < contador; i++) {
            if (trainers[i].getId() == id) {
                return trainers[i];
            }
        }
        return null;
    }

    public void leerTrainer() {
        for (int i = 0; i < contador; i++) {
            System.out.println(trainers[i]);
        }
    }

    public void actualizarTrainer(int id, int n_documento, String nombre, String apellidotrainer, int n_celular) {
        for (int i = 0; i < contador; i++) {
            if (trainers[i].getId() == id) {
                trainers[i].setN_documento(n_documento);
                trainers[i].setNombre(nombre);
                trainers[i].setApellido(apellidotrainer);
                trainers[i].setN_celular(n_celular);
                System.out.println("Trainer con ID " + id + " ha sido actualizado.");
                return;
            }
        }
        System.out.println("Trainer con ID " + id + " no encontrado.");
    }

    public boolean eliminarTrainer(int id) {
        for (int i = 0; i < contador; i++) {
            if (trainers[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    trainers[j] = trainers[j + 1];
                }
                trainers[--contador] = null;
                return true;
            }
        }
        return false;
    }

    public int getContador() {
        return contador;
    }

    public Trainers[] getAllTrainers() {
        return trainers;
    }

    public void modificarJornada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del trainer al cual desea asignarle un horario: ");
        int ID_trainer = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < contador; i++) {
            if (trainers[i].getId() == ID_trainer) {
                System.out.println("\nJornadas:");
                System.out.println("1. Mañana (6:00 a.m - 2:00 p.m)");
                System.out.println("2. Tarde (2:00 p.m - 10:00 p.m)");

                System.out.print("Seleccione la jornada que desea asignar: ");
                String opcion = scanner.nextLine();

                if (opcion.equals("1")) {
                    trainers[i].setJornada("Mañana(6:00 a.m - 2:00 p.m)");
                } else if (opcion.equals("2")) {
                    trainers[i].setJornada("Tarde (2:00 p.m - 10:00 p.m)");
                } else {
                    System.out.println("Ingrese una opción válida.");
                }
                return;
            }
        }
        System.out.println("Trainer con ID " + ID_trainer + " no encontrado.");
    }
}
