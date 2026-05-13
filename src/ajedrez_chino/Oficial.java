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
public class Oficial extends cdp{

    public Oficial(boolean team, int fila, int columna) {
        super(team ? "O" : "o", team, fila, columna, team ? "src/ajedrez_chino/Piezas/Oficial.png":"src/ajedrez_chino/Piezas/Oficial-Azul.png");
    }

    

    @Override
    public boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero) {
        if (nuevaCol < 3 || nuevaCol > 5) {
            JOptionPane.showMessageDialog(null, "Esta afuera del limite del palacio ");
            return false;
        }
        
        int difFila = Math.abs(nuevaFila - fila);
        int difCol = Math.abs(nuevaCol - col);
        
        return(difFila == 1 && difCol == 1);
    }
    
}
