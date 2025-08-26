
package LSP.Ejercicio2;


public abstract class Tecnico {
    protected String nombre;

    public Tecnico(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void realizarExamen(String tipoExamen);
}
    


