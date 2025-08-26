/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
public class ResultadoLaboratorio implements Validable {
    private String idResultado;
    private String valores;
    private boolean validado;

    public ResultadoLaboratorio(String idResultado, String valores) {
        this.idResultado = idResultado;
        this.valores = valores;
        this.validado = false;
    }

    @Override
    public void validar() {
        this.validado = true;
    }

    @Override
    public boolean isValidado() {
        return validado;
    }

    public String getReporte() {
        return "Resultado ID: " + idResultado +
               "\nValores: " + valores +
               "\nValidado: " + (validado ? "Sí" : "No");
    }
}

