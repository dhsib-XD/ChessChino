package ajedrez_chino;

public class Jugador implements IJugador {
    
    private String nombre;
    private String contrasena;

    public Jugador(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getContrasena() {
        return contrasena; // ✅ retorna el valor, no lanza excepción
    }

    @Override
    public void setContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena; // ✅ asigna el valor
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Usuario: " + nombre); // ✅ implementado
    }
}