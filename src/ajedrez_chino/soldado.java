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


public class soldado extends cdp {
    
    public soldado(boolean team, int fila, int columna) {
        super(team ? "S" : "s", team, fila, columna, team ? "src/ajedrez_chino/Piezas/Soldado.png":"src/ajedrez_chino/Piezas/Soldado-Azul.png");
    }
    
    @Override
    public boolean vmove(int nuevaFila, int nuevaColumna, cdp[][] tablero) {
        int difFila = nuevaFila - fila;
        int difCol = Math.abs(nuevaColumna - col);
        
        if (team) {
           
            if (fila > 4) { 
                return difFila == -1 && difCol == 0;
            } else { 
                return (difFila == -1 && difCol == 0) || (difFila == 0 && difCol == 1);
            }
        } else {
            
            if (fila < 5) { 
                return difFila == 1 && difCol == 0;
            } else { 
                return (difFila == 1 && difCol == 0) || (difFila == 0 && difCol == 1);
            }
        }
    }
}