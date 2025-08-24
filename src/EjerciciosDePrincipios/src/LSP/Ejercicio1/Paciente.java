package LSP.Ejercicio1;

/**
 *
 * @author User
 */
public class Paciente extends Persona {
    private String fechaNacimiento;
    private String telefono;

    public Paciente(String id, String nombres, String apellidos, String dni, String fechaNacimiento, String telefono) {
        super(id, nombres, apellidos, dni);
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    @Override
    public String getInformacionGeneral() {
        return "Paciente: " + nombres + " " + apellidos + " (Telefono: " + telefono + ")";
    }
}