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
public class PermisosTecnico implements IPermisosStrategy {

    @Override
    public void aplicarPermisos(MainForm main) {
        // Solo accesos permitidos
        main.getBtnResultados().setEnabled(true);
        main.getBtnTomaMuestras().setEnabled(true);

        // Lo demás bloqueado
        main.getBtnValidarResultados().setEnabled(false);
        main.getBtnOrdenesLaboratorio().setEnabled(false);
        main.getBtnPacientes().setEnabled(false);
        main.getBtnFacturacion().setEnabled(false);
        main.getBtnDetalleFacturas().setEnabled(false);
        main.getBtnMedicos().setEnabled(false);
        main.getBtnReportes().setEnabled(false);
        main.getBtnAdministrarUsuarios().setEnabled(false);
    }

}
