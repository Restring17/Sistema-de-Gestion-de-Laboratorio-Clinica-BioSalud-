package Singleton;

/**
 *
 * @author User
 */
public class ConfiguracionSistema {

    private static ConfiguracionSistema instancia;

    private ConfiguracionSistema() {
    }

    public static ConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionSistema();
        }
        return instancia;
    }

    public void mostrarConfiguracion() {
        System.out.println("Mostrando configuración del sistema BioSalud.");
    }
}