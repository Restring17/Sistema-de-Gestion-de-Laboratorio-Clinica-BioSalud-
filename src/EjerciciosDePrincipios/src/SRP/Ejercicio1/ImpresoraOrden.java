
package SRP.Ejercicio1;

public class ImpresoraOrden {
    
    public void imprimir(OrdenLaboratorio orden, Examen examen){
        System.out.println("Orden #"+orden.getFechaOrden()+
                           "\nFecha: "+ orden.getFechaOrden()+
                           "\nPaciente: "+ orden.getPaciente()+
                           "\nMedico: "+ orden.getIdMedico()+
                           "\nExamen: "+ examen.getTipoExamen()+
                            "("+examen.getObservaciones()+")"
                );
    }
    
}
