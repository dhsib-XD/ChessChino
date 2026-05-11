/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author CarlosXl
 */
public class game {
    boolean turns = true;
    public static void main(String[] args) {
        game a = new game();
        a.tablero();
    }
    public void tablero() {
        JFrame tab = new JFrame();
        tab.setSize(560, 680);
        tab.setLayout(null);
        tab.setLocationRelativeTo(null);
        tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        int[] seleccion = {-1, -1};
        cdp[][] fichas = new cdp[11][10];
        JButton[][] botones = new JButton[11][10];
       
        
        //Ficha de color  negro = fslse
        fichas[0][0] = new Carro("Carro",false,0,0);
        fichas[0][1] = new Caballo("Caballo",false,0,1);
        fichas[0][2] = new Elefante("Elefante",false,0,2);
        fichas[0][3] = new Oficial(false,0,3);
        fichas[0][4] = new General(false,0,4);
        fichas[0][5] = new Oficial(false,0,5);
        fichas[0][6] = new Elefante("Elefante",false,0,6);
        fichas[0][7] = new Caballo("Caballo",false,0,7);
        fichas[0][8] = new Carro("Carro",false,0,8);
        fichas[2][1] = new Canon("Canon",false,2,1);
        fichas[2][7] = new Canon("Canon",false,2,7);
        fichas[3][0] = new soldado(false, 3, 0);
        fichas[3][2] = new soldado(false, 3, 2);
        fichas[3][4] = new soldado(false, 3, 4);
        fichas[3][6] = new soldado(false, 3, 6);
        fichas[3][8] = new soldado(false, 3, 8);
        
        //Fichas de color blanco = true
        fichas[10][0] = new Carro("Carro",true,10,0);
        fichas[10][1] = new Caballo("Caballo",true,10,1);
        fichas[10][2] = new Elefante("Elefante",true,10,2);
        fichas[10][3] = new Oficial(true,10,3);
        fichas[10][4] = new General(true,10,4);
        fichas[10][5] = new Oficial(true,10,5);
        fichas[10][6] = new Elefante("Elefante",true,10,6);
        fichas[10][7] = new Caballo("Caballo",true,10,7);
        fichas[10][8] = new Carro("Carro",true,10,8);
        fichas[8][1] = new Canon("Canon",true,8,1);
        fichas[8][7] = new Canon("Canon",true,8,7);
        fichas[7][0] = new soldado(true, 7, 0);
        fichas[7][2] = new soldado(true, 7, 2);
        fichas[7][4] = new soldado(true, 7, 4);
        fichas[7][6] = new soldado(true, 7, 6);
        fichas[7][8] = new soldado(true, 7, 8);
        
       final int col = 9;
       final int fila = 11;
       final int x = 40;
       final int y = 30;
       final int size = 55;
       
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < col; j++) {
                if (i != 5) {  
                JButton cel = new JButton();
                cel.setBounds(x+(j*size), y+(i*size), size, size);
                cel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
                  
                   
                
                botones[i][j] = cel;
                final int fi = i;
                final int fj = j;
                
                cel.addActionListener( e->{
                    if (seleccion[0] == -1) {
                        
                    
                    if (fichas[fi][fj] == null) {
                        return;
                        
                    }
                    if (fichas[fi][fj].Team() != turns) {
                            JOptionPane.showMessageDialog(tab, "No es tu turno");
                            return;
                    }
                    
                        seleccion[0] = fi;
                        seleccion[1] = fj;
                        cel.setBackground(Color.CYAN); 
                    }else{
                        int a = seleccion[0];
                        int b = seleccion[1];
                        
                        if (a == fi && b == fj) {
                            restaurarColor(botones[a][b], a, b);
                            seleccion[0] = -1;
                            seleccion[1] = -1;
                            return;
                        }
                        if (fichas[fi][fj] != null && fichas[fi][fj].Team() == fichas[a][b].Team()) {
                            JOptionPane.showMessageDialog(tab, "No puedes capturar tu propia ficha");
                            restaurarColor(botones[a][b], a, b);
                            seleccion[0] = -1;
                            seleccion[1] = -1;
                            return;
                        }
                         
                        if (fichas[a][b].vmove(fi, fj, fichas)){
                            fichas[fi][fj] = fichas[a][b];
                            fichas[fi][fj].mover(fi, fj);
                            fichas[a][b] = null;
                            
                            Image img = fichas[fi][fj].getImagen().getImage();
                            Image imgE = img.getScaledInstance(size - 5, size - 5, Image.SCALE_SMOOTH);
                            botones[fi][fj].setIcon(new ImageIcon(imgE));
                            botones[a][b].setIcon(null);
                            
                           turns = !turns;
                        }else {
                            JOptionPane.showMessageDialog(tab, "Movimiento invalido");
                        }

                        restaurarColor(botones[a][b], a, b);
                        seleccion[0] = -1;
                        seleccion[1] = -1;
                    
                        
                    }
                    
                });
                
                tab.add(cel);
                
               
                    
                if ((i + j) % 2 == 0) {
                cel.setBackground(new Color(0, 120, 0));     
            } else {
                cel.setBackground(new Color(240, 230, 180)); 
            }
                
                    
                    
                     if ( i == 0 || i == 1 || i == 2) {
                        if (j == 3 || j == 4 || j == 5) {
                            cel.setBackground(Color.red);
                        }
                    }
                    
                    if ( i == 8 || i == 9 || i == 10) {
                        if (j == 3 || j == 4 || j == 5) {
                            cel.setBackground(Color.yellow);
                        }
                    }
                    
                    
                    
                    

            cel.setOpaque(true);
            
                 if (fichas[i][j] != null) {
               
                Image img = fichas[i][j].getImagen().getImage();
                Image imgEscalada = img.getScaledInstance(size - 5, size - 5, Image.SCALE_SMOOTH);
                cel.setIcon(new ImageIcon(imgEscalada)); // 👈 Poner imagen en botón
            }
                 
            }else{
                    JLabel rio = new JLabel();
                    rio.setBounds(x+(j*size), y+(i*size), size, size);
                    rio.setBorder(BorderFactory.createLineBorder(Color.blue,3));
                    rio.setBackground(new Color(100, 180, 255));
                    tab.add(rio);
                }
           
            
            }
            
        }
        
        tab.setVisible(true);
         
        
    }
     private void restaurarColor(JButton btn, int i, int j) {
        if ((i == 0 || i == 1 || i == 2) && (j == 3 || j == 4 || j == 5)) {
            btn.setBackground(Color.RED);
        } else if ((i == 8 || i == 9 || i == 10) && (j == 3 || j == 4 || j == 5)) {
            btn.setBackground(Color.YELLOW);
        } else if ((i + j) % 2 == 0) {
            btn.setBackground(new Color(0, 120, 0));
        } else {
            btn.setBackground(new Color(240, 230, 180));
        }
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
   
