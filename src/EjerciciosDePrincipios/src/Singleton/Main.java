package Singleton;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        ConfiguracionAplicacion apt= ConfiguracionAplicacion.getInstancia();

        ConexionDB conexion = ConexionDB.getInstancia();
        conexion.ejecutarConsulta("SELECT * FROM pacientes");

        GestorLogs logger = GestorLogs.getInstancia();
        logger.registrarEvento("Se ha iniciado el sistema.");
        
    }
}
