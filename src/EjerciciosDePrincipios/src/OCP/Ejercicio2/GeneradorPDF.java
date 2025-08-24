
package OCP.Ejercicio2;

public class GeneradorPDF implements GenerarInforme{

    @Override
    public void generar(String contenido) {
       System.out.println("PDF generandose.." + contenido );}
    
}
