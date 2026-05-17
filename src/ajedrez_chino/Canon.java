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
public class Canon extends cdp{

    public Canon(String nom, boolean team, int fila, int col) {
        super(team ? "Canon Blanco" : "Canon Azul", team, fila, col, team ? "src/ajedrez_chino/Piezas/Canon.png":"src/ajedrez_chino/Piezas/Canon-Azul.png");
    }

   

    @Override
public boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero) {
    
   
    if (fila != nuevaFila && col != nuevaCol) {
        return false;
    }

    int piezasmid = 0;

    
    if (fila == nuevaFila) {
        int min = Math.min(col, nuevaCol);
        int max = Math.max(col, nuevaCol);

        for (int i = min + 1; i < max; i++) {
            if (tablero[fila][i] != null) {
                piezasmid++;
            }
        }

    
    } else {
        int min = Math.min(fila, nuevaFila);
        int max = Math.max(fila, nuevaFila);

        for (int i = min + 1; i < max; i++) {
            if (tablero[i][col] != null) {
                piezasmid++;
            }
        }
    }

    
    if (tablero[nuevaFila][nuevaCol] == null) {
        return piezasmid == 0; 
    }

    
    return piezasmid == 1; 
}
    
}
