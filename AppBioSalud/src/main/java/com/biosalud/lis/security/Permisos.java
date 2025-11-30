/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.security;

/**
 *
 * @author folli
 */
public class Permisos {

    public static boolean puedeAcceder(String rol, String modulo) {

        return switch (rol) {

            case "ADMIN" -> true;

            case "RECEPCIONISTA" -> modulo.matches("Paciente|OrdenLaboratorio|Resultado|Factura|DetalleFactura");

            case "TECNICO" -> modulo.matches("ValidacionResultado|Resultado|TomaMuestra");

            case "ASISTENTE" -> modulo.matches("Medico|AdministrarUsuarios|Reporte|Factura|DetalleFactura");

            case "MEDICO" -> modulo.matches("Resultado|Pacientes");

            case "BIOQUIMICO" -> modulo.matches("ValidacionResultado|Resultado");

            default -> false;
        };
    }
}

