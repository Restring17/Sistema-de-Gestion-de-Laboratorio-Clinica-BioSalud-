/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author folli
 */
public class SeguimientoDecorator extends OrdenLaboratorioDecorator {

    public SeguimientoDecorator(OrdenLaboratorio ordenLaboratorio) {
        super(ordenLaboratorio);
    }

    @Override
    public void realizarExamen() {
        super.realizarExamen();
        realizarSeguimiento();
    }

    public void realizarSeguimiento() {
        System.out.println("Realizando seguimiento de la orden de laboratorio.");
    }

    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + " - Con seguimiento";
    }
}
