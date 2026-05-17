/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.awt.Color;

/**
 *
 * @author CarlosXl
 */
public class Elefante extends cdp{

    public Elefante(String nom, boolean team, int fila, int col) {
       super(team ? "Elefante Blanco" : "Elefante Azul", team, fila, col, team ? "src/ajedrez_chino/Piezas/Elefante.png":"src/ajedrez_chino/Piezas/Elefante-Azul.png");
    }

    

    @Override
public boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero) {
    
    int difFila = Math.abs(nuevaFila - fila);
    int difCol  = Math.abs(nuevaCol  - col);
    
    
    if (difFila != 2 || difCol != 2) {
        return false;
    }
    
    
    if (team) {
       
        if (nuevaFila <= 4) {
            return false;
        }
    } else {
        
        if (nuevaFila >= 5) {
            return false;
        }
    }
   
    int filaMedio = (fila + nuevaFila) / 2;
    int colMedio  = (col  + nuevaCol)  / 2;
    
    if (tablero[filaMedio][colMedio] != null) {
        return false; 
    }
    
    return true;
}
}