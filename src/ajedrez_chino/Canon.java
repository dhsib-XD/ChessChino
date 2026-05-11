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
        super(team ? "C" : "c", team, fila, col, team ? "src/ajedrez_chino/Piezas/Canon.png":"src/ajedrez_chino/Piezas/Canon-Azul.png");
    }

   

    @Override
    public boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
