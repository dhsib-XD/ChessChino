/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ajedrez_chino;



/**
 *
 * @author CarlosXl
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;



public class game {
    boolean turns = true;
    String jugadorBlanco;
    String jugadorAzul;
    static int noms = 0;

    public game(String jugadorBlanco, String jugadorAzul) {
        this.jugadorBlanco = jugadorBlanco;
        this.jugadorAzul   = jugadorAzul;
    }

    final void tablero() {
        JFrame tab = new JFrame("Ajedrez Chino");
        tab.setSize(780, 750);
        tab.setLayout(null);
        tab.setLocationRelativeTo(null);
        tab.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[] seleccion = {-1, -1};
        cdp[][] fichas      = new cdp[10][9];
        JButton[][] botones = new JButton[10][9];

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
        final int Y    = 60;
        final int size = 55;
        final int Vrio = 5;

        JLabel lblTurno = new JLabel("Turno: " + jugadorBlanco + " (Blancas)", JLabel.CENTER);
        lblTurno.setBounds(X, 5, col * size, 30);
        lblTurno.setFont(new Font("Arial", Font.BOLD, 14));
        tab.add(lblTurno);

        int panelX = X + (col * size) + 15;

        JLabel lblMuertos = new JLabel("Piezas eliminadas:", JLabel.CENTER);
        lblMuertos.setBounds(panelX, 5, 150, 25);
        lblMuertos.setFont(new Font("Arial", Font.BOLD, 12));
        tab.add(lblMuertos);

        JLabel lblB = new JLabel(jugadorBlanco + " perdió:");
        lblB.setBounds(panelX, 35, 150, 20);
        lblB.setFont(new Font("Arial", Font.BOLD, 11));
        tab.add(lblB);

        JTextArea cajaBlancos = new JTextArea();
        cajaBlancos.setEditable(false);
        cajaBlancos.setFont(new Font("Arial", Font.PLAIN, 11));
        cajaBlancos.setBackground(new Color(255, 255, 200));
        JScrollPane scrollB = new JScrollPane(cajaBlancos);
        scrollB.setBounds(panelX, 55, 150, 180);
        tab.add(scrollB);

        JLabel lblA = new JLabel(jugadorAzul + " perdió:");
        lblA.setBounds(panelX, 245, 150, 20);
        lblA.setFont(new Font("Arial", Font.BOLD, 11));
        tab.add(lblA);

        JTextArea cajaAzules = new JTextArea();
        cajaAzules.setEditable(false);
        cajaAzules.setFont(new Font("Arial", Font.PLAIN, 11));
        cajaAzules.setBackground(new Color(200, 220, 255));
        JScrollPane scrollA = new JScrollPane(cajaAzules);
        scrollA.setBounds(panelX, 265, 150, 180);
        tab.add(scrollA);
        
       

        JButton btnRendir = new JButton("RENDIRSE");
        btnRendir.setBounds(panelX, 470, 150, 40);
        btnRendir.setBackground(Color.RED);
        btnRendir.setForeground(Color.WHITE);
        btnRendir.setFont(new Font("Arial", Font.BOLD, 12));
        btnRendir.addActionListener(e -> {
            String seRinde = turns ? jugadorBlanco : jugadorAzul;
            String gana    = turns ? jugadorAzul   : jugadorBlanco;

            int confirm = JOptionPane.showConfirmDialog(tab,
                seRinde + " ¿estás seguro que deseas rendirte?",
                "Confirmar rendición",
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String mensaje = seRinde + " SE HA RETIRADO, FELICIDADES " +
                                 gana + ", HAS GANADO 3 PUNTOS";
                JOptionPane.showMessageDialog(tab, mensaje);
                guardarLog(jugadorBlanco, mensaje);
                guardarLog(jugadorAzul, mensaje);

               
                darPuntos(gana, 3);

                tab.dispose();
                Menu m = new Menu();
                m.menuj();
            }
        });
        tab.add(btnRendir);

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
                cel.setFocusPainted(false);

                botones[i][j] = cel;
                final int fi = i;
                final int fj = j;

                if ((i + j) % 2 == 0) {
                    cel.setBackground(new Color(0, 120, 0));
                } else {
                    cel.setBackground(new Color(240, 230, 180));
                }

                if (i <= 2 && j >= 3 && j <= 5) cel.setBackground(Color.RED);
                if (i >= 7 && j >= 3 && j <= 5) cel.setBackground(Color.YELLOW);

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

                            if (fichas[fi][fj] != null) {
                                String nombrePieza = fichas[fi][fj].getNom();
                                if (fichas[fi][fj].Team()) {
                                    cajaBlancos.append("- " + nombrePieza + "\n");
                                } else {
                                    cajaAzules.append("- " + nombrePieza + "\n");
                                }
                            }

                            fichas[fi][fj] = fichas[a][b];
                            fichas[fi][fj].mover(fi, fj);
                            fichas[a][b] = null;

                            Image img = fichas[fi][fj].getImagen().getImage();
                            Image imgE = img.getScaledInstance(size - 5, size - 5, Image.SCALE_SMOOTH);
                            botones[fi][fj].setIcon(new ImageIcon(imgE));
                            botones[a][b].setIcon(null);

                            if (verificarGanador(fichas)) {
                                String gana   = turns ? jugadorBlanco : jugadorAzul;
                                String pierde = turns ? jugadorAzul   : jugadorBlanco;
                                String msg    = "JUGADOR " + gana + " VENCIÓ A " + pierde +
                                                ", FELICIDADES HAS GANADO 3 PUNTOS";

                                JOptionPane.showMessageDialog(tab, msg);
                                guardarLog(jugadorBlanco, msg);
                                guardarLog(jugadorAzul, msg);

                                
                                darPuntos(gana, 3);

                                tab.dispose();
                                Menu m = new Menu();
                                m.menuj();
                                return;
                            }

                            turns = !turns;
                            lblTurno.setText("Turno: " +
                                (turns ? jugadorBlanco + " (Blancas)"
                                       : jugadorAzul   + " (Azules)"));

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

  
    private void darPuntos(String nombreGanador, int puntos) {
        for (int i = 0; i < dp.totalUsuarios; i++) {
            if (dp.jugadores[i].getNombre().equals(nombreGanador)) {
                ((Jugador) dp.jugadores[i]).agregarPuntos(puntos);
                break;
            }
        }
    }

    private void guardarLog(String nombreJugador, String mensaje) {
        for (int i = 0; i < dp.totalUsuarios; i++) {
            if (dp.jugadores[i].getNombre().equals(nombreJugador)) {
                dp.jugadores[i].agregarLog(mensaje);
                break;
            }
        }
    }

    private boolean verificarGanador(cdp[][] fichas) {
        boolean generalNegro  = false;
        boolean generalBlanco = false;

        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].length; j++) {
                if (fichas[i][j] instanceof General) {
                    if (!fichas[i][j].Team()) generalNegro  = true;
                    if (fichas[i][j].Team())  generalBlanco = true;
                }
            }
        }
        return !generalNegro || !generalBlanco;
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