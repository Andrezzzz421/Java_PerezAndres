package crud;

import java.util.Scanner;

public class Salones {

    public Salones(String nombregrupo, int fechainicio, int fechafinal) {
    }

    private static int opcion;
    private static TrainerCrud trainerCrud = new TrainerCrud(10); // Asegúrate de inicializar con datos reales

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CrearSalones salon = new CrearSalones(); // Crear una instancia de CrearSalones

        System.out.print("Introduce los datos del salón:\n");
        System.out.print("Nombre del grupo: ");
        salon.setNombreGrupo(scanner.nextLine());
        System.out.print("Fecha de inicio: ");
        salon.setFechaInicio(scanner.nextInt());
        System.out.print("Fecha de finalización: ");
        salon.setFechaFinal(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        seleccionarTrainerYHorario(scanner, salon);
        menuRutas(scanner, salon);
        menuAreas(scanner, salon);

        System.out.println("Salón creado con éxito:");
        System.out.println(salon);
    }

    public static void seleccionarTrainerYHorario(Scanner scanner, CrearSalones salon) {
        while (true) {
            try {
                System.out.print("Ingrese el ID del Trainer que se encargará de este salón: ");
                int idTrainer = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                if (!trainerCrud.existeTrainer(idTrainer)) {
                    System.out.println("Trainer con ID " + idTrainer + " no encontrado. Inténtelo de nuevo.");
                    continue;
                }

                Trainers trainerSeleccionado = trainerCrud.obtenerTrainer(idTrainer);

                while (true) {
                    if (trainerSeleccionado.getJornada().contains("Mañana")) {
                        System.out.println("Elige uno de los dos horarios disponibles para la jornada en la que el trainer está disponible:");
                        System.out.println("1. 6:00 am - 10:00 am");
                        System.out.println("2. 10:00 am - 2:00 pm");
                        String eleccion = scanner.nextLine();

                        if (eleccion.equals("1")) {
                            salon.setHorario("6:00 am - 10:00 am");
                            break;
                        } else if (eleccion.equals("2")) {
                            salon.setHorario("10:00 am - 2:00 pm");
                            break;
                        } else {
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                        }
                    } else if (trainerSeleccionado.getJornada().contains("Tarde")) {
                        System.out.println("Elige uno de los dos horarios disponibles para la jornada en la que el trainer está disponible:");
                        System.out.println("1. 2:00 pm - 6:00 pm");
                        System.out.println("2. 6:00 pm - 10:00 pm");
                        String eleccion = scanner.nextLine();

                        if (eleccion.equals("1")) {
                            salon.setHorario("2:00 pm - 6:00 pm");
                            break;
                        } else if (eleccion.equals("2")) {
                            salon.setHorario("6:00 pm - 10:00 pm");
                            break;
                        } else {
                            System.out.println("Opción no válida. Inténtelo de nuevo.");
                        }
                    } else {
                        System.out.println("El entrenador aún no tiene una jornada asignada.");
                        return;
                    }
                }

                salon.setTrainerEncargado(trainerSeleccionado.getNombre());
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.next(); // Limpiar entrada no válida
            }
        }
    }

    public static void menuRutas(Scanner scanner, CrearSalones salon) {
        System.out.println("\nRutas disponibles:");
        System.out.println("1. Ruta NodeJS");
        System.out.println("2. Ruta Java");
        System.out.println("3. Ruta NetCore");

        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        procesarOpcionRutas(salon);
    }

    public static void menuAreas(Scanner scanner, CrearSalones salon) {
        System.out.println("\nÁreas de entrenamiento disponibles:");
        System.out.println("1. Sputnik");
        System.out.println("2. Artemis");
        System.out.println("3. Apolo");

        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        procesarOpcionAreas(salon);
    }

    public static void procesarOpcionRutas(CrearSalones salon) {
        switch (opcion) {
            case 1:
                salon.setRuta("NodeJS");
                System.out.println("Has seleccionado la Ruta NodeJS.");
                break;
            case 2:
                salon.setRuta("Java");
                System.out.println("Has seleccionado la Ruta Java.");
                break;
            case 3:
                salon.setRuta("NetCore");
                System.out.println("Has seleccionado la Ruta NetCore.");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;
        }
    }

    public static void procesarOpcionAreas(CrearSalones salon) {
        switch (opcion) {
            case 1:
                salon.setSalon("Sputnik");
                System.out.println("Has seleccionado el área Sputnik.");
                break;
            case 2:
                salon.setSalon("Artemis");
                System.out.println("Has seleccionado el área Artemis.");
                break;
            case 3:
                salon.setSalon("Apolo");
                System.out.println("Has seleccionado el área Apolo.");
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;
        }
    }

    public static class CrearSalones {
        private static int nextId = 1;
        private int id;
        private String nombregrupo;
        private String ruta;
        private String salon;
        private String trainerencargado;
        private String horario;
        private int fechainicio;
        private int fechafinal;

        public CrearSalones() {
            this.id = nextId++;
            this.nombregrupo = "";
            this.ruta = "";
            this.salon = "";
            this.trainerencargado = "";
            this.horario = "";
            this.fechainicio = 0;
            this.fechafinal = 0;
        }

        public int getId() {
            return id;
        }

        public String getNombreGrupo() {
            return nombregrupo;
        }

        public void setNombreGrupo(String nombreGrupo) {
            this.nombregrupo = nombreGrupo;
        }

        public String getRuta() {
            return ruta;
        }

        public void setRuta(String ruta) {
            this.ruta = ruta;
        }

        public String getSalon() {
            return salon;
        }

        public void setSalon(String salon) {
            this.salon = salon;
        }

        public String getTrainerEncargado() {
            return trainerencargado;
        }

        public void setTrainerEncargado(String trainerEncargado) {
            this.trainerencargado = trainerEncargado;
        }

        public String getHorario() {
            return horario;
        }

        public void setHorario(String horario) {
            this.horario = horario;
        }

        public int getFechaInicio() {
            return fechainicio;
        }

        public void setFechaInicio(int fechaInicio) {
            this.fechainicio = fechaInicio;
        }

        public int getFechaFinal() {
            return fechafinal;
        }

        public void setFechaFinal(int fechaFinal) {
            this.fechafinal = fechaFinal;
        }

        @Override
        public String toString() {
            return "Salon{id=" + id +
                    ", nombre de grupo='" + nombregrupo + '\'' +
                    ", ruta='" + ruta + '\'' +
                    ", salon='" + salon + '\'' +
                    ", trainerEncargado='" + trainerencargado + '\'' +
                    ", horario='" + horario + '\'' +
                    ", fecha de inicio=" + fechainicio +
                    ", fecha de finalizacion=" + fechafinal +
                    '}';
        }
    }
}
