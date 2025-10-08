package consola;

public class OrdenLaboratorio {

    String idOrden, tipoExamen, observaciones, fechaOrden,
            paciente, medico;

    double calcularCosto() {
        switch (tipoExamen.toLowerCase()) {
            case "hemograma compelto":
                return 45.0;

            case "glucosa":
                return 30.0;

            case "orina completa":
                return 25.0;

            default:
                return 40.0;
        }
    }

    void mostrarInfo() {
        System.out.println("ORDEN DE LABORATORIO");
        System.out.println("Codigo: " + idOrden);
        System.out.println("Paciente: " + paciente);
        System.out.println("Medico: " + medico);
        System.out.println("Tipo de examen: " + tipoExamen);
        System.out.println("Observaciones: " + observaciones);
        System.out.println("Fecha: " + fechaOrden);
        System.out.println("Costo estimado: S/." + calcularCosto());
    }

}
