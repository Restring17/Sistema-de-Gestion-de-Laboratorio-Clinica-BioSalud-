/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.strategy;

import com.biosalud.lis.ui.MainForm;

/**
 *
 * @author folli
 */
public class PermisosRecepcionista implements IPermisosStrategy {

    @Override
    public void aplicarPermisos(MainForm main) {
        // Solo accesos permitidos
        main.getBtnPacientes().setEnabled(true);
        main.getBtnOrdenesLaboratorio().setEnabled(true);
        main.getBtnResultados().setEnabled(true);
        main.getBtnFacturacion().setEnabled(true);
        main.getBtnDetalleFacturas().setEnabled(true);

        // Lo demás bloqueado
        main.getBtnMedicos().setEnabled(false);
        main.getBtnTomaMuestras().setEnabled(false);
        main.getBtnValidarResultados().setEnabled(false);
        main.getBtnReportes().setEnabled(false);
        main.getBtnAdministrarUsuarios().setEnabled(false);
    }

}
