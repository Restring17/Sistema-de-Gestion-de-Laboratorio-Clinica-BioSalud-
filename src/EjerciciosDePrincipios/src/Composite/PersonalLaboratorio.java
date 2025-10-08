
package Composite;
// Hoja
class PersonalLaboratorio implements INotificable {
    private String rol;
    private String nombre;
    
    public PersonalLaboratorio(String rol, String nombre) {
        this.rol = rol;
        this.nombre = nombre;
    }
    
    @Override
    public void recibirAlerta(String mensaje) {
        System.out.println("[" + rol + " - " + nombre + "] Recibió la alerta: " + mensaje);
    }
}