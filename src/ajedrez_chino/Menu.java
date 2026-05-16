/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez_chino;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author CarlosXl
 */
public class Menu extends dp {
    Menu_Inicio me = new Menu_Inicio();

    public void menuj() {
        JFrame inicio = new JFrame("Ajedrez Chino");
        inicio.setSize(560, 680);
        inicio.setLocationRelativeTo(null);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setLayout(null);

        JLabel titulo = new JLabel("Ajedrez Chino");
        titulo.setBounds(180, 50, 250, 50);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);

        JButton bj = new JButton("JUGAR");
        bj.setBounds(210, 200, 120, 40);
        bj.addActionListener(e -> {
            int usu = 0;
            boolean find = false;

            if (dp.totalUsuarios >= 2) {
                String p2 = JOptionPane.showInputDialog(null, "Ingrese el nombre del segundo jugador:");
                if (p2 == null || p2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                    return;
                }

                for (int i = 0; i < dp.totalUsuarios; i++) {
                    if (dp.jugadores[i].getNombre().equals(p2)) {
                        find = true;
                        usu  = i;
                    }
                }

                if (find && usu == dp.Jactual) {
                    JOptionPane.showMessageDialog(null, "No puedes jugar contra ti mismo");
                    return;
                }

                if (find) {
                    String c2 = JOptionPane.showInputDialog(null, "Ingrese la contraseña del segundo jugador:");
                    if (c2 == null || c2.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe ingresar la contraseña");
                        return;
                    }

                    if (c2.equals(dp.jugadores[usu].getContrasena())) {
                        String jugador1 = dp.jugadores[dp.Jactual].getNombre();
                        String jugador2 = dp.jugadores[usu].getNombre();

                        JOptionPane.showMessageDialog(null,
                            "Blancas: " + jugador1 +
                            "\nAzules:  " + jugador2);

                        game g = new game(jugador1, jugador2);
                        g.tablero();
                        inicio.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario no existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficientes jugadores registrados");
            }
        });

        JButton bc = new JButton("MI CUENTA");
        bc.setBounds(210, 260, 120, 40);
        bc.addActionListener(e -> {
            MICUENTA();
            inicio.dispose();
        });

        JButton br = new JButton("Reportes");
        br.setBounds(210, 320, 120, 40);
        br.addActionListener(e -> {
            reportes(inicio); // 👈 Abrir reportes
        });

        JButton bl = new JButton("LOG OUT");
        bl.setBounds(210, 380, 120, 40);
        bl.addActionListener(e -> {
            me.menui();
            inicio.dispose();
        });

        inicio.add(titulo);
        inicio.add(bj);
        inicio.add(bc);
        inicio.add(br);
        inicio.add(bl);

        Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
        Image imgE = img.getScaledInstance(560, 680, Image.SCALE_SMOOTH);
        JLabel fondo = new JLabel(new ImageIcon(imgE));
        fondo.setBounds(0, 0, 560, 680);
        inicio.add(fondo);

        inicio.setVisible(true);
    }

    public void reportes(JFrame anterior) {
        JFrame rep = new JFrame("Reportes");
        rep.setSize(560, 680);
        rep.setLayout(null);
        rep.setLocationRelativeTo(null);
        rep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titulo = new JLabel("REPORTES", JLabel.CENTER);
        titulo.setBounds(0, 10, 540, 40);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setForeground(Color.WHITE);
        rep.add(titulo);

        
        JLabel lblRanking = new JLabel("RANKING DE JUGADORES");
        lblRanking.setBounds(20, 60, 250, 25);
        lblRanking.setFont(new Font("Arial", Font.BOLD, 14));
        lblRanking.setForeground(Color.WHITE);
        rep.add(lblRanking);

        JTextArea txtRanking = new JTextArea();
        txtRanking.setEditable(false);
        txtRanking.setFont(new Font("Courier New", Font.PLAIN, 13));
        txtRanking.setBackground(new Color(240, 240, 240));

      
        IJugador[] ordenados = new IJugador[dp.totalUsuarios];
        for (int i = 0; i < dp.totalUsuarios; i++) {
            ordenados[i] = dp.jugadores[i];
        }

        for (int i = 0; i < dp.totalUsuarios - 1; i++) {
            for (int j = 0; j < dp.totalUsuarios - i - 1; j++) {
                if (((Jugador) ordenados[j]).getPuntos() < ((Jugador) ordenados[j + 1]).getPuntos()) {
                    IJugador temp  = ordenados[j];
                    ordenados[j]   = ordenados[j + 1];
                    ordenados[j + 1] = temp;
                }
            }
        }

       
        txtRanking.append(String.format("%-5s %-15s %-10s%n", "POS", "USERNAME", "PUNTOS"));
        txtRanking.append("─────────────────────────────\n");
        for (int i = 0; i < dp.totalUsuarios; i++) {
            txtRanking.append(String.format("%-5d %-15s %-10d%n",
                i + 1,
                ordenados[i].getNombre(),
                ((Jugador) ordenados[i]).getPuntos()
            ));
        }

        JScrollPane scrollRanking = new JScrollPane(txtRanking);
        scrollRanking.setBounds(20, 90, 500, 180);
        rep.add(scrollRanking);

        // ─── MIS ÚLTIMOS PARTIDOS ───────────────────────────
        JLabel lblLogs = new JLabel("MIS ÚLTIMOS PARTIDOS");
        lblLogs.setBounds(20, 285, 250, 25);
        lblLogs.setFont(new Font("Arial", Font.BOLD, 14));
        lblLogs.setForeground(Color.WHITE);
        rep.add(lblLogs);

        JTextArea txtLogs = new JTextArea();
        txtLogs.setEditable(false);
        txtLogs.setFont(new Font("Courier New", Font.PLAIN, 12));
        txtLogs.setBackground(new Color(240, 240, 240));

        
        String[] misLogs = dp.jugadores[dp.Jactual].getLog();
        int total= dp.jugadores[dp.Jactual].getTotal();

        if (total == 0) {
            txtLogs.append("No hay partidos registrados aún.");
        } else {
            for (int i = total - 1; i >= 0; i--) { // 👈 Del más reciente al más viejo
                txtLogs.append((total - i) + ". " + misLogs[i] + "\n");
                txtLogs.append("─────────────────────────────────────────\n");
            }
        }

        JScrollPane scrollLogs = new JScrollPane(txtLogs);
        scrollLogs.setBounds(20, 315, 500, 230);
        rep.add(scrollLogs);

        // ─── BOTÓN REGRESAR ─────────────────────────────────
        JButton regresar = new JButton("REGRESAR");
        regresar.setBounds(200, 560, 120, 35);
        regresar.addActionListener(e -> {
            rep.dispose();
        });
        rep.add(regresar);

        Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
        Image imgE = img.getScaledInstance(560, 680, Image.SCALE_SMOOTH);
        JLabel fondo = new JLabel(new ImageIcon(imgE));
        fondo.setBounds(0, 0, 560, 680);
        rep.add(fondo);

        rep.setVisible(true);
    }
}