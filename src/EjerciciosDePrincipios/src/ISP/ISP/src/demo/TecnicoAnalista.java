
package demo;

public class TecnicoAnalista implements AnalisisLaboratorio{

    @Override
    public void analizarMuestra(String muestra) {
        System.out.println("Analizando muestra: "+ muestra);
    }
    
}
