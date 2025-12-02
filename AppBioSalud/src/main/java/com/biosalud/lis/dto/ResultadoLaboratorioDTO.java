
package com.biosalud.lis.dto;

import java.time.LocalDateTime;

public class ResultadoLaboratorioDTO {

    private int idResultado;
    private int idOrden;
    private LocalDateTime fecha;
    private boolean validado;

    public ResultadoLaboratorioDTO(int idResultado, int idOrden, LocalDateTime fecha, boolean validado) {
        this.idResultado = idResultado;
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.validado = validado;
    }

    public int getIdResultado() {
        return idResultado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean isValidado() {
        return validado;
    }
}