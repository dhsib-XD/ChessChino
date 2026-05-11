/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author CarlosXl
 */
public abstract class cdp {
    String nom;
    Color color;
    int fila;
    int col;
    boolean team;
    protected ImageIcon imagen;

    public cdp(String nom, boolean team, int fila, int col,String rutaImagen) {
        this.nom = nom;
        this.color = color;
        this.fila = fila;
        this.col = col;
        this.color = team ? Color.RED : Color.BLACK;
        
        Image img = new ImageIcon(rutaImagen).getImage();
        Image imgEscalada = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        this.imagen = new ImageIcon(imgEscalada);
    }

    public ImageIcon getImagen() {
        return imagen;
    }
    
    
    
    public abstract boolean vmove(int nuevaFila, int nuevaCol, cdp[][] tablero);
    
    
    public void mover(int nuevafila,int nuevacol){
        this.fila = nuevafila;
        this.col = nuevacol;
        
        
    }

    public String getNom() {
        return nom;
    }

    public Color getColor() {
        return color;
    }

    public int getFila() {
        return fila;
    }

    public int getCol() {
        return col;
    }

    public boolean Team() {
        return team;
    }
    
    @Override
    public String toString() {
        return nom + " en (" + fila + "," + col + ")";
    }
    
    
}
