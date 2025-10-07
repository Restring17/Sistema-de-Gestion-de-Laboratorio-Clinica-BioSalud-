/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbstractFactory;

/**
 *
 * @author KEVIN
 */
public class FabricaDigital implements FabricaServiciosLaboratorio {
    @Override
    public Informe crearInforme() {
        return new InformeDigital();
    }

    @Override
    public Notificacion crearNotificacion() {
        return new NotificacionEmail();
    }
}

