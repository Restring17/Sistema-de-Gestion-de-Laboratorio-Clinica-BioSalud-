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
public class PermisosAdmin implements IPermisosStrategy {

    @Override
    public void aplicarPermisos(MainForm main) {
        // Admin tiene todo habilitado
        main.getBtnPacientes().setEnabled(true);
        main.getBtnMedicos().setEnabled(true);
        main.getBtnOrdenesLaboratorio().setEnabled(true);
        main.getBtnTomaMuestras().setEnabled(true);
        main.getBtnResultados().setEnabled(true);
        main.getBtnValidarResultados().setEnabled(true);
        main.getBtnFacturacion().setEnabled(true);
        main.getBtnDetalleFacturas().setEnabled(true);
        main.getBtnReportes().setEnabled(true);
        main.getBtnAdministrarUsuarios().setEnabled(true);
    }

}
