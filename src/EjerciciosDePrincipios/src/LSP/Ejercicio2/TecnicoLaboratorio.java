
package LSP.Ejercicio2;


public class TecnicoLaboratorio extends Tecnico {
   
  public TecnicoLaboratorio(String nombre) {
        super(nombre); // Llama al constructor de la clase abstracta
    }

    @Override
    public void realizarExamen(String tipoExamen) {
        System.out.println(nombre + " está realizando el examen: " + tipoExamen);
    }
}

    


