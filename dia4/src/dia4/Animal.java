package dia4;

public class Animal {
    private int edad;
    private String tipo;
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void caminar() {
        System.out.println("El " + tipo + " está caminando y tiene " + edad + " años.");
    }
    
    public void correr(){
        System.out.println("El " + tipo + " esta corriendo y tiene " + edad + "años.");
    }
}
