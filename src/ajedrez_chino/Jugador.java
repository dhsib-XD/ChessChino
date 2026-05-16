package ajedrez_chino;

public final class Jugador implements IJugador {
    private String nombre;
    private String contrasena;
    private String[] logs = new String[100];
    private int totalLogs = 0;
    private int puntos = 0; 

    public Jugador(String nombre, String contrasena) {
        this.nombre     = nombre;
        this.contrasena = contrasena;
    }

    @Override 
    public String getNombre(){ 
        return nombre; }
    
    @Override 
    public String getContrasena(){ 
        return contrasena; }
    
    @Override 
    public void setContrasena(String nueva) {
        this.contrasena = nueva; }
    
     public void agregarLog(String log) {
        logs[totalLogs] = log;
        totalLogs++;
    }
    public String[] getLog()  { 
        return logs; }
    
    public int getTotal()  { 
        return totalLogs; }

    
    public int getPuntos() { 
        return puntos; }
    public void agregarPuntos(int p) { 
        puntos += p; }

    @Override
    public String toString() { 
        return nombre; }


    public void mostrarDatos() {
        System.out.println("Usuario: " + nombre); 
    }

}