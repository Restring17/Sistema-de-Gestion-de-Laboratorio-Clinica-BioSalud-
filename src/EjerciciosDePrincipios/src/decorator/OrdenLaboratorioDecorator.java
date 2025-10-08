/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author folli
 */
public abstract class OrdenLaboratorioDecorator implements OrdenLaboratorio {

    protected OrdenLaboratorio ordenLaboratorio;

    public OrdenLaboratorioDecorator(OrdenLaboratorio ordenLaboratorio) {
        this.ordenLaboratorio = ordenLaboratorio;
    }

    @Override
    public void realizarExamen() {
        ordenLaboratorio.realizarExamen();
    }

    @Override
    public String obtenerDetalles() {
        return ordenLaboratorio.obtenerDetalles();
    }
}
