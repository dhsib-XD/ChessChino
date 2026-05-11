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

/**
 *
 * @author CarlosXl
 */
public class Menu {
    Menu_Inicio me = new Menu_Inicio();
  public void menuj() {
    dp dp = new dp();

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
       
    });

    JButton bc = new JButton("MI CUENTA");
    bc.setBounds(210, 260, 120, 40);
    bc.addActionListener(e -> {
        dp.MICUENTA(); 
        inicio.dispose();
    });

    JButton br = new JButton("Reportes");
    br.setBounds(210, 320, 120, 40);

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
    Image imgEscalada = img.getScaledInstance(560, 680, Image.SCALE_SMOOTH);
    JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
    fondo.setBounds(0, 0, 560, 680);
    inicio.add(fondo); 

    inicio.setVisible(true);
}
}