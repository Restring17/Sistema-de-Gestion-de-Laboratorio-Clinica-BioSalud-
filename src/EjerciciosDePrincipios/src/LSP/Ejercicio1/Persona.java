package LSP.Ejercicio1;

/**
 *
 * @author User
 */
public abstract class Persona {
    public String id;
    public String nombres;
    public String apellidos;
    public String dni;

    public Persona(String id, String nombres, String apellidos, String dni) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public abstract String getInformacionGeneral();

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
}