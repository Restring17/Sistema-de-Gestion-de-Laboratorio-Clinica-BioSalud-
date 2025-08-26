/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
public class OrdenLaboratorio {
    private String idOrden;
    private String tipoExamen;
    private Paciente paciente;
    private Medico medico;

    public OrdenLaboratorio(String idOrden, String tipoExamen, Paciente paciente, Medico medico) {
        this.idOrden = idOrden;
        this.tipoExamen = tipoExamen;
        this.paciente = paciente;
        this.medico = medico;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }
}
