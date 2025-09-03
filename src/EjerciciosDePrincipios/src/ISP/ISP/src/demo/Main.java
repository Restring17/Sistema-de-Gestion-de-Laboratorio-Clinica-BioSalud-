
package demo;


public class Main {

    public static void main(String[] args) {
        TomaMuestra recolector = new TecnicoRecolector();
        recolector.extraerMuestra("Paciente Maria Lopez");
        
        
        AnalisisLaboratorio analista = new TecnicoAnalista();
        analista.analizarMuestra("Muestra de orina");
        
        ValidacionResultado validador = new TecnicoValidador();
        validador.validar("Hemoglobina: 14g/dL");
    }
    
}
