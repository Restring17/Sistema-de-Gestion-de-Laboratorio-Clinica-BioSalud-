package Singleton;

/**
 *
 * @author User
 */
public class GestorLogs {

    private static volatile GestorLogs instancia;

    private GestorLogs() {
    }

    public static GestorLogs getInstancia() {
        if (instancia == null) {
            synchronized (GestorLogs.class) {
                if (instancia == null) {
                    instancia = new GestorLogs();
                }
            }
        }
        return instancia;
    }

    public void registrarEvento(String evento) {
        System.out.println("[LOG]: " + evento);
    }
}
