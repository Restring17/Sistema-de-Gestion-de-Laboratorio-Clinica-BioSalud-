
package OCP.Ejercicio2;

public class main {

    public static void main(String[] args) {
        ProcesadorInformes procesador = new ProcesadorInformes();
        
        // Informe en PDF
        procesador.procesar("Informe completo", new GeneradorPDF());
        
        // Informe en TXT
        procesador.procesar("Informe completo", new GeneradorTXT());
        
    }
}

