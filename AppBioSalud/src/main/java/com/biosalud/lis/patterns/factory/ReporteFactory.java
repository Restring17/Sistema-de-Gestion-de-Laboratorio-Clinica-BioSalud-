/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.patterns.factory;

import com.biosalud.lis.patterns.command.GenerarReporteCommand;

/**
 *
 * @author folli
 */
public class ReporteFactory {
    public static GenerarReporteCommand createGenerarReporteCommand() {
        return new GenerarReporteCommand();
    }
}

