/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


package ajedrez_chino;

public interface IJugador {
    String getNombre();
    String getContrasena();
    void setContrasena(String nueva);
    void agregarLog(String log);
    String[] getLog();      
    int getTotal();      
}