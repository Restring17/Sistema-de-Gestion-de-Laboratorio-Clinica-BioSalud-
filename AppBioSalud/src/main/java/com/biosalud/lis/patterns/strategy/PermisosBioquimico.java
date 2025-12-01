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
public class PermisosBioquimico implements IPermisosStrategy{

    @Override
    public void aplicarPermisos(MainForm main) {
        // Solo accesos permitidos
        main.getBtnValidarResultados().setEnabled(true);
        main.getBtnResultados().setEnabled(true);

        // Lo demás bloqueado
        main.getBtnOrdenesLaboratorio().setEnabled(false);
        main.getBtnPacientes().setEnabled(false);
        main.getBtnFacturacion().setEnabled(false);
        main.getBtnTomaMuestras().setEnabled(true);
        main.getBtnDetalleFacturas().setEnabled(false);
        main.getBtnMedicos().setEnabled(false);
        main.getBtnReportes().setEnabled(false);
        main.getBtnAdministrarUsuarios().setEnabled(false);
    }
    
}
