
package LSP.Ejercicio2;

import java.time.LocalDateTime;

public class RegistroTomaMuestra {
   String idMuestra;
    String tipoExamen;
    String tecnico;
    String fechaHora;

    public RegistroTomaMuestra(Paciente paciente, Tecnico tecnico, String tipoExamen) {
        this.idMuestra = paciente.id;
        this.tipoExamen = tipoExamen;
        this.tecnico = tecnico.getNombre();
        this.fechaHora = LocalDateTime.now().toString(); // Usar toString() para obtener la fecha y hora
        tecnico.realizarExamen(tipoExamen); // Llama al método para realizar el examen
    }

    @Override
    public String toString() {
        return "Muestra ID: " + idMuestra + "\n" +
           "Tipo de Examen: " + tipoExamen + "\n" +
           "Técnico: " + tecnico + "\n" +
           "Fecha y Hora: " + fechaHora ;
    }
}
    
    

