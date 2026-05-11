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
import javax.swing.JTextField;

/**
 *
 * @author CarlosXl
 */
public class Login extends dp { 
    
    public void log() {
    Menu_Inicio m = new Menu_Inicio();
    Menu mm = new Menu();
    JFrame log = new JFrame("LOGIN");
    log.setSize(500, 500);
    log.setLocationRelativeTo(null);
    log.setLayout(null);
    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    JLabel tt = new JLabel("INICIAR SESIÓN");
    tt.setBounds(150, 50, 250, 50);
    tt.setFont(new Font("Arial", Font.BOLD, 23));
    tt.setForeground(Color.WHITE); 

    JLabel txtu = new JLabel("Usuario:");
    txtu.setBounds(100, 150, 100, 35);
    txtu.setForeground(Color.WHITE); 

    JLabel txtc = new JLabel("Contraseña:");
    txtc.setBounds(100, 210, 100, 35);
    txtc.setForeground(Color.WHITE); 

    JTextField usuario = new JTextField();
    usuario.setBounds(200, 150, 200, 35);

    JTextField contra = new JTextField();
    contra.setBounds(200, 210, 200, 35);

    JButton regresar = new JButton("REGRESAR");
    regresar.setBounds(250, 330, 120, 40);
    regresar.addActionListener(e -> {
        m.menui();
        log.dispose();
    });

    JButton entrar = new JButton("ENTRAR");
    entrar.setBounds(100, 330, 120, 40);
    entrar.addActionListener(e -> {
        String user = usuario.getText();
        String pass = contra.getText();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(log, "Complete todos los campos");
            return;
        }

        if (verificar(0, user, pass)) {
            JOptionPane.showMessageDialog(log, "¡Bienvenido " + user + "!");
            mm.menuj();
            log.dispose();
        } else {
            JOptionPane.showMessageDialog(log, "Usuario o contraseña incorrectos");
        }
    });

    
    log.add(tt);
    log.add(txtu);
    log.add(txtc);
    log.add(usuario);
    log.add(contra);
    log.add(entrar);
    log.add(regresar);

    
    Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
    Image imgEscalada = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
    fondo.setBounds(0, 0, 500, 500);
    log.add(fondo); 

    log.setVisible(true);
}
}