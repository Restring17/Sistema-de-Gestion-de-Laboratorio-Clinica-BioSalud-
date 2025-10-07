/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author KEVIN
 */

public class Main {
    public static void main(String[] args) {

        // Caso 1: Entrega Digital
        FabricaServiciosLaboratorio fabricaDigital = new FabricaDigital();
        Informe informeDigital = fabricaDigital.crearInforme();
        Notificacion notiEmail = fabricaDigital.crearNotificacion();

        informeDigital.generar();
        notiEmail.enviar("Sus resultados de laboratorio ya están disponibles en línea.");

        System.out.println("--------------------------------------------------");

        // Caso 2: Entrega Física
        FabricaServiciosLaboratorio fabricaFisica = new FabricaFisica();
        Informe informePDF = fabricaFisica.crearInforme();
        Notificacion notiSMS = fabricaFisica.crearNotificacion();

        informePDF.generar();
        notiSMS.enviar("Sus resultados están listos para recoger en recepción.");
    }
}
