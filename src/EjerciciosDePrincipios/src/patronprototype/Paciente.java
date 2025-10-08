
package patronprototype;

public class Paciente implements Cloneable {

    private String nombre;
    private int edad;
    private String telefono;
    private String correo;

        public Paciente(String nombre, int edad, String telefono, String correo) {
            this.nombre = nombre;
            this.edad = edad;
            this.telefono = telefono;
            this.correo = correo;
        }

    @Override
    public Paciente clone(){
        try {
            return (Paciente) super.clone(); // clon superficial (valores copiados)
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar el paciente",e);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public void mostrarInfo() {
        System.out.println("\n Paciente: " + nombre
                         + "\n Edad: " + edad 
                         + "\n Telefono: " + telefono 
                         + "\n Correo: " + correo);
    }

}
    
    
    
    

