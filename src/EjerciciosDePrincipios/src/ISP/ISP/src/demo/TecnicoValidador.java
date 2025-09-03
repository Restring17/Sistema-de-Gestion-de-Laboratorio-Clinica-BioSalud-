
package demo;


public class TecnicoValidador implements ValidacionResultado{

    @Override
    public void validar(String resultado) {

        System.out.println("Validando resultado: "+resultado);
    }
    
}
