package Singleton;

/**
 *
 * @author User
 */
public class ConfiguracionAplicacion {

    private static final ConfiguracionAplicacion instancia = new ConfiguracionAplicacion();

    private ConfiguracionAplicacion() {
    }

    public static ConfiguracionAplicacion getInstancia() {
        return instancia;
    }
}