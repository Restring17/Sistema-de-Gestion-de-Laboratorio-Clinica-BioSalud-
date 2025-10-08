
package consola;


public class Main {


    public static void main(String[] args) {
        
        OrdenLaboratorio orden1 = new OrdenLaboratorioBuilder()
                .setIdOrden("ORD-1001")
                .setPaciente("Ana Guzman")
                .setMedico("Dr. Chavez")
                .setTipoExamen("Hemograma Completo")
                .setObservaciones("Ayuno de 8 horas")
                .setFechaOrden("2025-10-07")
                .build();
                
                
                orden1.mostrarInfo();
                
                
    }
    
}
