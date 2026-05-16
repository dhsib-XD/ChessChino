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
public class Menu_Inicio extends dp {
    public void menui(){
        
        
        Login l = new Login();
        
        JFrame mi = new JFrame();
        mi.setSize(500, 500);
        mi.setLayout(null);
        mi.setLocationRelativeTo(null);
        
        JButton log =new JButton("LOG IN");
        log.setBounds(190,210,120,40);
        log.addActionListener(e -> {
            l.log();
            mi.dispose();
        });
        
        JButton player =new JButton("NEW PLAYER");
        player.setBounds(190,270,120,40);
        player.addActionListener(e -> nuevo());
        
        player.addActionListener(e -> mi.dispose());
        
        JLabel tt = new JLabel("AJEDREZ CHINO");
        tt.setBounds(150, 50, 250, 50);
        tt.setFont(new Font("Arial", Font.BOLD, 23));
        tt.setForeground(Color.BLACK);
        
        JButton salir =new JButton("SALIR");
        salir.setBounds(190,330,120,40);
        salir.addActionListener(e -> mi.dispose());
        
        
        mi.add(tt);
        mi.add(salir);
        mi.add(player);
        mi.add(log);
        mi.setVisible(true);
        
    Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
    Image imgEscalada = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
    fondo.setBounds(0, 0, 500, 500);
    mi.add(fondo); 

    mi.setVisible(true);
    }
}
