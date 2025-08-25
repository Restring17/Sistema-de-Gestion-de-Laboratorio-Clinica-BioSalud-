
package LSP.Ejercicio2;


public class TecnicoLaboratorio implements Tecnico {
    String nombre;

    public TecnicoLaboratorio(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void realizarExamen(String tipoExamen) {
        System.out.println(nombre + " está realizando el examen: " + tipoExamen);
    }

 
}

    

