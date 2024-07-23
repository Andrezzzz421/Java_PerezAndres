package crud;

public class Camper {
    private static int nextId = 1;
    private int id;
    private int n_documento;
    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String ciudad;
    private String direccion;
    private String acudiente;
    private int n_celular;
    private int n_fijo;
    private String estado;
    private int notaPractica;
    private int notaTeorica;

    public Camper(int n_documento, String nombre, String nombre2, String apellido, String apellido2, String ciudad, String direccion, String acudiente, int n_celular, int n_fijo) {
        this.id = nextId++;
        this.n_documento = n_documento;
        this.nombre = nombre;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.acudiente = acudiente;
        this.n_celular = n_celular;
        this.n_fijo = n_fijo;
        this.estado = "Inscrito";
    }

    // Getters y Setters
    public int getId() { return id; }
    public int getN_documento() { return n_documento; }
    public void setN_documento(int n_documento) { this.n_documento = n_documento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getNombre2() { return nombre2; }
    public void setNombre2(String nombre2) { this.nombre2 = nombre2; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getAcudiente() { return acudiente; }
    public void setAcudiente(String acudiente) { this.acudiente = acudiente; }
    public int getN_celular() { return n_celular; }
    public void setN_celular(int n_celular) { this.n_celular = n_celular; }
    public int getN_fijo() { return n_fijo; }
    public void setN_fijo(int n_fijo) { this.n_fijo = n_fijo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public int getNotaPractica() { return notaPractica; }
    public void setNotaPractica(int notaPractica) { this.notaPractica = notaPractica; }
    public int getNotaTeorica() { return notaTeorica; }
    public void setNotaTeorica(int notaTeorica) { this.notaTeorica = notaTeorica; }

    public void actualizarEstado() {
        double notaIngreso = notaPractica + notaTeorica * 0.2;
        if (notaIngreso >= 60) {
            this.estado = "Aprobado";
        } else {
            this.estado = "Reprobado";
        }
    }

    @Override
    public String toString() {
        return "Camper{id=" + id + 
               ", n_documento=" + n_documento + 
               ", nombre='" + nombre + '\'' + 
               ", nombre2='" + nombre2 + '\'' + 
               ", apellido='" + apellido + '\'' + 
               ", apellido2='" + apellido2 + '\'' + 
               ", ciudad='" + ciudad + '\'' + 
               ", direccion='" + direccion + '\'' + 
               ", acudiente='" + acudiente + '\'' + 
               ", n_celular=" + n_celular + 
               ", n_fijo=" + n_fijo + 
               ", estado='" + estado + '\'' + 
               ", notaPractica=" + notaPractica + 
               ", notaTeorica=" + notaTeorica + 
               '}';
    }
}
