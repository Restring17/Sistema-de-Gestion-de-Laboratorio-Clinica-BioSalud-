/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LSP.Ejercicio2;

/**
 *
 * @author User
 */
public class main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente("Carla","Celestino Morales","77335049","001");
        Tecnico tecnico = new TecnicoLaboratorio("Diana Flores");
        String tipoExamen = "Hemograma , Glucosa";

       
        RegistroTomaMuestra registro = new RegistroTomaMuestra(paciente, tecnico, tipoExamen);
        System.out.println("Registro de toma de muestra guardado:");
        System.out.println(registro);
    }
}
