package ajedrez_chino;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class game {
    boolean turns = true;

    public static void main(String[] args) {
        game a = new game();
        a.tablero();
    }

    public void tablero() {
        JOptionPane.showMessageDialog(null, "Comienza las fichas Blancas y luego las fichas Azules");
        JFrame tab = new JFrame();
        tab.setSize(560, 720);
        tab.setLayout(null);
        tab.setLocationRelativeTo(null);
        tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[] seleccion = {-1, -1};

       
        cdp[][] fichas   = new cdp[10][9];
        JButton[][] botones = new JButton[10][9];

        //  Fichas negras 
        fichas[0][0] = new Carro("Carro", false, 0, 0);
        fichas[0][1] = new Caballo("Caballo", false, 0, 1);
        fichas[0][2] = new Elefante("Elefante", false, 0, 2);
        fichas[0][3] = new Oficial(false, 0, 3);
        fichas[0][4] = new General(false, 0, 4);
        fichas[0][5] = new Oficial(false, 0, 5);
        fichas[0][6] = new Elefante("Elefante", false, 0, 6);
        fichas[0][7] = new Caballo("Caballo", false, 0, 7);
        fichas[0][8] = new Carro("Carro", false, 0, 8);
        fichas[2][1] = new Canon("Canon", false, 2, 1);
        fichas[2][7] = new Canon("Canon", false, 2, 7);
        fichas[3][0] = new soldado(false, 3, 0);
        fichas[3][2] = new soldado(false, 3, 2);
        fichas[3][4] = new soldado(false, 3, 4);
        fichas[3][6] = new soldado(false, 3, 6);
        fichas[3][8] = new soldado(false, 3, 8);

        //  Fichas blancas
        fichas[9][0] = new Carro("Carro", true, 9, 0);
        fichas[9][1] = new Caballo("Caballo", true, 9, 1);
        fichas[9][2] = new Elefante("Elefante", true, 9, 2);
        fichas[9][3] = new Oficial(true, 9, 3);
        fichas[9][4] = new General(true, 9, 4);
        fichas[9][5] = new Oficial(true, 9, 5);
        fichas[9][6] = new Elefante("Elefante", true, 9, 6);
        fichas[9][7] = new Caballo("Caballo", true, 9, 7);
        fichas[9][8] = new Carro("Carro", true, 9, 8);
        fichas[7][1] = new Canon("Canon", true, 7, 1);
        fichas[7][7] = new Canon("Canon", true, 7, 7);
        fichas[6][0] = new soldado(true, 6, 0);
        fichas[6][2] = new soldado(true, 6, 2);
        fichas[6][4] = new soldado(true, 6, 4);
        fichas[6][6] = new soldado(true, 6, 6);
        fichas[6][8] = new soldado(true, 6, 8);

        final int col  = 9;
        final int fila = 10; 
        final int X    = 40;
        final int Y    = 30;
        final int size = 55;
        final int Vrio = 5; 

        
        for (int j = 0; j < col; j++) {
            JLabel rio = new JLabel();
            rio.setBounds(X + (j * size), Y + (Vrio * size), size, size);
            rio.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            rio.setBackground(new Color(100, 180, 255));
            rio.setOpaque(true);
            tab.add(rio);
        }

       
        for (int i = 0; i < fila; i++) {
            
            int visualRow = (i < 5) ? i : i + 1;

            for (int j = 0; j < col; j++) {
                JButton cel = new JButton();
                cel.setBounds(X + (j * size), Y + (visualRow * size), size, size);
                cel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                cel.setOpaque(true);

                botones[i][j] = cel;
                final int fi = i;
                final int fj = j;

               
                if ((i + j) % 2 == 0) {
                    cel.setBackground(new Color(0, 120, 0));
                } else {
                    cel.setBackground(new Color(240, 230, 180));
                }

              
                if (i <= 2 && j >= 3 && j <= 5) {
                    cel.setBackground(Color.RED);
                }

               
                if (i >= 7 && j >= 3 && j <= 5) {
                    cel.setBackground(Color.YELLOW);
                }

                
                if (fichas[i][j] != null) {
                    Image img = fichas[i][j].getImagen().getImage();
                    Image imgE = img.getScaledInstance(size - 5, size - 5, Image.SCALE_SMOOTH);
                    cel.setIcon(new ImageIcon(imgE));
                }

                
                cel.addActionListener(e -> {
                    if (seleccion[0] == -1) {
                        
                        if (fichas[fi][fj] == null) return;
                        if (fichas[fi][fj].Team() != turns) {
                            JOptionPane.showMessageDialog(tab, "No es tu turno");
                            return;
                        }
                        seleccion[0] = fi;
                        seleccion[1] = fj;
                        cel.setBackground(Color.CYAN);

                    } else {
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

                        
                        if (fichas[a][b].vmove(fi, fj, fichas)) {
                            fichas[fi][fj] = fichas[a][b];
                            fichas[fi][fj].mover(fi, fj);
                            fichas[a][b] = null;

                            Image img = fichas[fi][fj].getImagen().getImage();
                            Image imgE = img.getScaledInstance(size - 5, size - 5, Image.SCALE_SMOOTH);
                            botones[fi][fj].setIcon(new ImageIcon(imgE));
                            botones[a][b].setIcon(null);

                            turns = !turns;
                        } else {
                            JOptionPane.showMessageDialog(tab, "Movimiento invalido");
                        }

                        restaurarColor(botones[a][b], a, b);
                        seleccion[0] = -1;
                        seleccion[1] = -1;
                    }
                });

                tab.add(cel);
            }
        }

        tab.setVisible(true);
    }

    private void restaurarColor(JButton btn, int i, int j) {
        if (i <= 2 && j >= 3 && j <= 5) {
            btn.setBackground(Color.RED);
        } else if (i >= 7 && j >= 3 && j <= 5) {
            btn.setBackground(Color.YELLOW);
        } else if ((i + j) % 2 == 0) {
            btn.setBackground(new Color(0, 120, 0));
        } else {
            btn.setBackground(new Color(240, 230, 180));
        }
    }
}