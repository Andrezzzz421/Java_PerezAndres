package dia4.ejemplo2_Herencia;

public class Main {

    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Pepito", "12345678", "E001");
        System.out.println("Nombre: " + estudiante1.getNombre());
        System.out.println("Documento: " + estudiante1.getDocumento());
        System.out.println("Código Estudiante: " + estudiante1.getCodigoEstudiante());
    }
}
