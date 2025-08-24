package LSP.Ejercicio1;

/**
 *
 * @author User
 */
public class Medico extends Persona {
    private String especialidad;
    private String cmp; // Código de Médico del Perú

    public Medico(String id, String nombres, String apellidos, String dni, String especialidad, String cmp) {
        super(id, nombres, apellidos, dni);
        this.especialidad = especialidad;
        this.cmp = cmp;
    }

    @Override
    public String getInformacionGeneral() {
        return "Medico: " + nombres + " " + apellidos + " (Especialidad: " + especialidad + ", CMP: " + cmp + ")";
    }
}