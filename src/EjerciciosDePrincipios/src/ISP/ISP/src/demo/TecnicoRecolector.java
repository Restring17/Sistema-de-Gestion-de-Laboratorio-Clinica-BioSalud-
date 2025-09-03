
package demo;


public class TecnicoRecolector implements TomaMuestra {

    @Override
    public void extraerMuestra(String paciente) {
        System.out.println("Extrayendo muestra de paciente: "+ paciente);
        
    }
    
}
