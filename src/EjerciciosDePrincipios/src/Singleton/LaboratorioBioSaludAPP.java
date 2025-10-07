package Singleton;

/**
 *
 * @author User
 */
public class LaboratorioBioSaludAPP {

    public static void main(String[] args) {
        System.out.println("--- Inicio de la aplicación del Laboratorio BioSalud ---");


        Thread moduloPacientes = new Thread(() -> {
            ConexionBioSaludDB conexion = ConexionBioSaludDB.getInstancia();
            System.out.println("Módulo Pacientes: Obtenida instancia de conexión con hashcode: " + conexion.hashCode());
            conexion.mostrarInfoConexion();
            conexion.ejecutarConsulta("SELECT * FROM pacientes WHERE id = 123");
        });

        Thread moduloMuestras = new Thread(() -> {
            ConexionBioSaludDB conexion = ConexionBioSaludDB.getInstancia();
            System.out.println("Módulo Muestras: Obtenida instancia de conexión con hashcode: " + conexion.hashCode());
            conexion.ejecutarConsulta("INSERT INTO muestras (tipo, paciente_id) VALUES ('sangre', 123)");
        });

        moduloPacientes.start();
        moduloMuestras.start();

        try {
            moduloPacientes.join();
            moduloMuestras.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--- Fin de la aplicación ---");
    }
}
