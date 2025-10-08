
package Composite;
//Uso
public class Main {
    public static void main(String[] args) {

        INotificable tecnico = new PersonalLaboratorio("Técnico", "Carlos"); 
        INotificable bioquimico = new PersonalLaboratorio("Bioquímico", "Marta"); 
        INotificable medico = new PersonalLaboratorio("Médico", "Dr. Ríos"); 
        INotificable recepcionista = new PersonalLaboratorio("Recepcionista", "Ana"); 

        GrupoNotificacion equipoValidacion = new GrupoNotificacion("Equipo de Bioquímicos");
        equipoValidacion.addMiembro(bioquimico);
        GrupoNotificacion ordenNotificacion = new GrupoNotificacion("Orden N° 456 - Resultados Listos");

        ordenNotificacion.addMiembro(tecnico);          
        ordenNotificacion.addMiembro(equipoValidacion); 
        ordenNotificacion.addMiembro(medico);      
        ordenNotificacion.addMiembro(recepcionista); 

        String mensajeAlerta = "Los resultados de la orden 456 han sido VALIDADOS y están listos para ser entregados.";

        System.out.println("--- NOTIFICACIÓN AUTOMÁTICA DEL SISTEMA (LIS) ---");

        ordenNotificacion.recibirAlerta(mensajeAlerta);
    }
}