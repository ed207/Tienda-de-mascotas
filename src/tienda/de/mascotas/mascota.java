
package tienda.de.mascotas;


public class mascota {
    private int ID;
    private String nombre,raza;

    public mascota(int ID, String nombre, String raza) {
        this.ID = ID;
        this.nombre = nombre;
        this.raza = raza;
    }

    public int getID() {
        return ID;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
}
