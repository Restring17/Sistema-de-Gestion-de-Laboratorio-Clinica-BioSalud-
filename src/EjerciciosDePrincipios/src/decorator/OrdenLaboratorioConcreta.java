/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author folli
 */
public class OrdenLaboratorioConcreta implements OrdenLaboratorio {
    private String tipoExamen;

    public OrdenLaboratorioConcreta(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    @Override
    public void realizarExamen() {
        System.out.println("Realizando examen de tipo: " + tipoExamen);
    }

    @Override
    public String obtenerDetalles() {
        return "Orden de laboratorio para examen de " + tipoExamen;
    }
}
