
package SRP.Ejercicio1;

public class OrdenLaboratorio {
    
    private int idOrden;
    private String fechaOrden;    
    private String paciente;
    private String idMedico;

    public OrdenLaboratorio(int idOrden, String fechaOrden, String paciente, String idMedico) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.paciente = paciente;
        this.idMedico = idMedico;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getIdMedico() {
        return idMedico;
    }    
    
    
}
