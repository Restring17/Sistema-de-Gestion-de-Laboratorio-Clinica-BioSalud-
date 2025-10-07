package Singleton;

/**
 *
 * @author User
 */
public class ConexionDB {

    private static ConexionDB instancia;

    private ConexionDB() {
        System.out.println("Conexión a la base de datos establecida.");
    }

    public static synchronized ConexionDB getInstancia() {
        if (instancia == null) {
            instancia = new ConexionDB();
        }
        return instancia;
    }

    // Métodos para operaciones de base de datos
    public void ejecutarConsulta(String consulta) {
        System.out.println("Ejecutando consulta: " + consulta);
    }
}