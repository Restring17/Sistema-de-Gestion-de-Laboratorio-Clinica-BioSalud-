package LSP.Ejercicio1;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        Persona persona;

        persona = new Medico("M001", "Carlos", "Vidal", "12345678", "Cardiologia", "CMP12345");
        System.out.println(persona.getInformacionGeneral());

        persona = new Paciente("P001", "Ana", "Torres", "87654321", "15-05-1990", "987654321");
        System.out.println(persona.getInformacionGeneral());
        
        persona = new TecnicoLaboratorio("T001", "Luis", "Gomez", "11223344", "Bioquimica");
        System.out.println(persona.getInformacionGeneral());
    }
}
