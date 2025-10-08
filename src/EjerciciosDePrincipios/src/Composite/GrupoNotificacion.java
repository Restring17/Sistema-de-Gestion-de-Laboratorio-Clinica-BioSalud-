
package Composite;
import java.util.ArrayList;
import java.util.List;
// Compuesto
class GrupoNotificacion implements INotificable {
    private String nombreGrupo;
    private List<INotificable> miembros = new ArrayList<>();
    
    public GrupoNotificacion(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    public void addMiembro(INotificable miembro) {
        miembros.add(miembro);
    }
    
    @Override
    public void recibirAlerta(String mensaje) {
        System.out.println("\n--- Notificando al Grupo: " + nombreGrupo + " ---");
        for (INotificable miembro : miembros) {
            miembro.recibirAlerta(mensaje);
        }
        System.out.println("------------------------------------------");
    }
}