package LSP.Ejercicio1;

/**
 *
 * @author User
 */
public class TecnicoLaboratorio extends Persona {
    private String especialidadTecnica;

    public TecnicoLaboratorio(String id, String nombres, String apellidos, String dni, String especialidadTecnica) {
        super(id, nombres, apellidos, dni);
        this.especialidadTecnica = especialidadTecnica;
    }
    
    @Override
    public String getInformacionGeneral() {
        return "Tecnico: " + nombres + " " + apellidos + " (Area: " + especialidadTecnica + ")";
    }
}