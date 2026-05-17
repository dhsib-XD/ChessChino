/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author CarlosXl
 */
public class General extends cdp {

    public General(boolean team, int fila, int columna) {
        super(team ? "General Blanco" : "General Azul", team, fila, columna, team ? "src/ajedrez_chino/Piezas/General.png":"src/ajedrez_chino/Piezas/General-Azul.png");
    }

    

    @Override
    public boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero) {
    
  
    if (nuevaCol < 3 || nuevaCol > 5) {
        return false;
    }
    
    
    if (team) {
        if (nuevaFila < 7 || nuevaFila > 9) return false;
    } else {
        if (nuevaFila < 0 || nuevaFila > 2) return false;
    }
    
    // Movimiento de 1 casilla ortogonal
    int difFila = Math.abs(nuevaFila - fila);
    int difCol  = Math.abs(nuevaCol  - col);
    if (!((difFila == 1 && difCol == 0) || (difFila == 0 && difCol == 1))) {
        return false;
    }
    
   
    int filaC = -1;
    int colC  = -1;

    for (int i = 0; i < tablero.length; i++) {
        for (int j = 3; j <= 5; j++) {
            if (tablero[i][j] != null && tablero[i][j].Team() != team && tablero[i][j].getClass().getSimpleName().equals("General")) {
                filaC = i;
                colC  = j;
                break;
            }
        }
        if (filaC != -1) break;
    }
    
   
    if (filaC != -1 && nuevaCol == colC) {
        boolean bloqueo = false;
        
        int filaMin = Math.min(nuevaFila, filaC) + 1;
        int filaMax = Math.max(nuevaFila, filaC) - 1;
        
        for (int f = filaMin; f <= filaMax; f++) {
            if (tablero[f][nuevaCol] != null) {
                bloqueo = true;
                break;
            }
        }
        
        if (!bloqueo) return false;
    }
    
    return true;
}
    
}

