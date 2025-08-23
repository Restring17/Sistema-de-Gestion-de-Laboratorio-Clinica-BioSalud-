
package ejercicioSRP1;

public class Main {
    public static void main(String[] args) {
        OrdenLaboratorio orden = new OrdenLaboratorio(1, "2025-08-21", "Federico","Dr. Lopez") ;
        Examen examen = new Examen("Hemoglobina", "Ayuno 8 horas");
        
        ImpresoraOrden impre = new ImpresoraOrden();
        impre.imprimir(orden, examen);
    }
    
    
}
