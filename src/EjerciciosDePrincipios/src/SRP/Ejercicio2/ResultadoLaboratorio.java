/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SRP.Ejercicio2;

/**
 *
 * @author KEVIN
 */
public class ResultadoLaboratorio {
    private String idResultado;
    private String valores;
    private boolean validado;

    public ResultadoLaboratorio(String idResultado, String valores) {
        this.idResultado = idResultado;
        this.valores = valores;
        this.validado = false;
    }

    public void validar() {
        this.validado = true;
    }

    public String getReporte() {
        return "Resultado ID: " + idResultado + 
               "\nValores: " + valores + 
               "\nValidado: " + (validado ? "Sí" : "No");
    }
}
