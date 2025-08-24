

package ejercicioSRP1;


public class Examen {
    private String tipoExamen;
    private String observaciones;

    public Examen(String tipoExamen, String observaciones) {
        this.tipoExamen = tipoExamen;
        this.observaciones = observaciones;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    
}
