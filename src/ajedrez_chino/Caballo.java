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
public class Caballo extends cdp{

    public Caballo(String nom, boolean team, int fila, int col) {
        super(team ? "Caballo Blanco" : "Caballo Azul", team, fila, col, team ? "src/ajedrez_chino/Piezas/Caballo.png":"src/ajedrez_chino/Piezas/Caballo-Azul.png");
    }
    

    

    @Override
    public boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero) {
    int difFila = nuevaFila - fila;
    int difCol  = nuevaCol  - col;

    

    if (Math.abs(difFila) == 2 && Math.abs(difCol) == 1) {
        
        int filaMedio = fila + (difFila > 0 ? 1 : -1);
        if (tablero[filaMedio][col] != null) {
            return false; 
        }

    } else if (Math.abs(difFila) == 1 && Math.abs(difCol) == 2) {
      
        int colMedio = col + (difCol > 0 ? 1 : -1);
        if (tablero[fila][colMedio] != null) {
            return false; 
        }

    } else {
        return false; 
    }

    return true;
}
    
}
