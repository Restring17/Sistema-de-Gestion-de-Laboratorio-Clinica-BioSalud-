/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author folli
 */
public class Main {

    public static void main(String[] args) {
        // Creando una orden de laboratorio basica (examen de sangre)
        OrdenLaboratorio ordenSangre = new OrdenLaboratorioConcreta("Sangre");

        // Mostrando detalles y realizando examen de la orden basica
        System.out.println("Orden original:");
        ordenSangre.realizarExamen();
        System.out.println(ordenSangre.obtenerDetalles());
        System.out.println("----------------------------");

        // Agregando el decorador de seguimiento
        OrdenLaboratorio ordenConSeguimiento = new SeguimientoDecorator(ordenSangre);
        System.out.println("Orden con seguimiento:");
        ordenConSeguimiento.realizarExamen();
        System.out.println(ordenConSeguimiento.obtenerDetalles());
        System.out.println("----------------------------");

        // Agregando el decorador de informe detallado
        OrdenLaboratorio ordenConInformeDetallado = new InformeDetalladoDecorator(ordenConSeguimiento);
        System.out.println("Orden con informe detallado:");
        ordenConInformeDetallado.realizarExamen();
        System.out.println(ordenConInformeDetallado.obtenerDetalles());
    }
}
