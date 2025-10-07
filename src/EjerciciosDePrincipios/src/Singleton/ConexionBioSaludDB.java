package Singleton;

/**
 *
 * @author User
 */
public class ConexionBioSaludDB {

    private static volatile ConexionBioSaludDB instancia;

    private String urlConexion;
    private String usuario;
    private String password;

    private ConexionBioSaludDB() {
        System.out.println("Inicializando conexión con la base de datos de BioSalud...");
        try {
            Thread.sleep(1000);
            this.urlConexion = "jdbc:mysql://localhost:3306/biosalud_db";
            this.usuario = "admin_lab";
            this.password = "secret_password*";
            System.out.println("¡Conexión establecida exitosamente!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ConexionBioSaludDB getInstancia() {
        if (instancia == null) {
            synchronized (ConexionBioSaludDB.class) {
                if (instancia == null) {
                    instancia = new ConexionBioSaludDB();
                }
            }
        }
        return instancia;
    }


    public void ejecutarConsulta(String sql) {
        System.out.println("Ejecutando consulta: '" + sql + "' en " + this.urlConexion);
    }

    public void mostrarInfoConexion() {
        System.out.println("Detalles de Conexión: URL=" + this.urlConexion + ", Usuario=" + this.usuario);
    }
}
