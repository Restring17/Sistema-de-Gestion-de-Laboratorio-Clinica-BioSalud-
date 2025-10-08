
package patronprototype;

public class Main {
    public static void main(String[] args) {
        // Creamos un paciente base
        Paciente pacienteOriginal = new Paciente("Maria", 23, "987654321", "Maria1234@gmail.com");
        pacienteOriginal.mostrarInfo();

        // Clonamos al paciente (patrón Prototype)
        Paciente pacienteClonado = pacienteOriginal.clone();

        // Modificamos algunos datos del clon
        pacienteClonado.setNombre("Carla");
        pacienteClonado.setCorreo("carla@gmail.com");

        // Mostramos los dos objetos (independientes)
        System.out.println("\n Pacientes en sistema:");
        pacienteOriginal.mostrarInfo();
        pacienteClonado.mostrarInfo();
    }
}
    
    

