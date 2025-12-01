/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.factory;

import com.biosalud.lis.patterns.strategy.IPermisosStrategy;
import com.biosalud.lis.patterns.strategy.PermisosAdmin;
import com.biosalud.lis.patterns.strategy.PermisosAsistente;
import com.biosalud.lis.patterns.strategy.PermisosBioquimico;
import com.biosalud.lis.patterns.strategy.PermisosMedico;
import com.biosalud.lis.patterns.strategy.PermisosRecepcionista;
import com.biosalud.lis.patterns.strategy.PermisosTecnico;

/**
 *
 * @author folli
 */
public class PermisosFactory {

    public static IPermisosStrategy getStrategy(String rol) {
        if (rol == null) {
            return null;
        }

        switch (rol.trim()) {
            case "ADMIN":
                return new PermisosAdmin();
            case "RECEPCIONISTA":
                return new PermisosRecepcionista();
            case "TECNICO":
                return new PermisosTecnico();
            case "ASISTENTE":
                return new PermisosAsistente();
            case "MEDICO":
                return new PermisosMedico();
            case "BIOQUIMICO":
                return new PermisosBioquimico();
            default:
                throw new IllegalArgumentException("Rol no válido: " + rol);
        }
    }
}
