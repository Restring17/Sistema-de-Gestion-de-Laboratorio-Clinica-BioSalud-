/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author folli
 */
public class InformeDetalladoDecorator extends OrdenLaboratorioDecorator {

    public InformeDetalladoDecorator(OrdenLaboratorio ordenLaboratorio) {
        super(ordenLaboratorio);
    }

    @Override
    public void realizarExamen() {
        super.realizarExamen();
        generarInformeDetallado();
    }

    public void generarInformeDetallado() {
        System.out.println("Generando informe detallado de los resultados del examen.");
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + " - Con informe detallado";
    }
}
