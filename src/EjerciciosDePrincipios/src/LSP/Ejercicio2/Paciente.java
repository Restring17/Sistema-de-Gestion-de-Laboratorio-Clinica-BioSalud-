package LSP.Ejercicio2;

public class Paciente {
    private String nombre;
    private String apellido;
    private String dni;
    String id;
//ll
    public Paciente(String nombre, String apellido, String dni, String id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }
}
    
    


