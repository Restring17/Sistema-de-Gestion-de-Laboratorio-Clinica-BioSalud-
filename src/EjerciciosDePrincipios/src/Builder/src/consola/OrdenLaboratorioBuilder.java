
package consola;


public class OrdenLaboratorioBuilder {

private OrdenLaboratorio orden = new OrdenLaboratorio();


public OrdenLaboratorioBuilder setIdOrden(String idOrden){
        orden.idOrden=idOrden;
        return this;
    }

    public OrdenLaboratorioBuilder setPaciente(String paciente){
        orden.paciente=paciente;
        return this;
    }
    public OrdenLaboratorioBuilder setMedico(String medico){
        orden.medico=medico;
        return this;
    }
    public OrdenLaboratorioBuilder setTipoExamen(String tipoExamen){
        orden.tipoExamen=tipoExamen;
        return this;
    }
    public OrdenLaboratorioBuilder setObservaciones(String observaciones){
        orden.observaciones=observaciones;
        return this;
    }
    public OrdenLaboratorioBuilder setFechaOrden(String fechaOrden){
        orden.fechaOrden=fechaOrden;
        return this;
    }
    
    
    public OrdenLaboratorio build(){
        
        if (orden.paciente==null || orden.medico==null||orden.tipoExamen==null) {
            
            throw new IllegalArgumentException("Debe ingresar paciente, medico y tipo de examen.");
            
        }
    return orden;
    }
}
