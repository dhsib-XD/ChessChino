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
public class Carro extends cdp{

    public Carro(String nom, boolean team, int fila, int col) {
        super(team ? "Carro Blanco" : "Carro Azul", team, fila, col, team ? "src/ajedrez_chino/Piezas/Carro.png":"src/ajedrez_chino/Piezas/Carro-Azul.png");
    }

    

    
    @Override
public boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero) {
    
  
    if (fila != nuevaFila && col != nuevaCol) {
        return false;
    }

   
    if (fila == nuevaFila) {
        int min = Math.min(col, nuevaCol);    
        int max = Math.max(col, nuevaCol);

        for (int i = min + 1; i < max; i++) {
            if (tablero[fila][i] != null) {
                return false; // Hay una pieza en el camino
            }
        }

   
    } else {
        int min = Math.min(fila, nuevaFila);   
        int max = Math.max(fila, nuevaFila);

        for (int i = min + 1; i < max; i++) { 
            if (tablero[i][col] != null) {
                return false; 
            }
        }
    }

    return true;
}
}
