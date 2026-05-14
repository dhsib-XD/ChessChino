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
public class dp  {
   static String noms[] = new String[100]; 
    static String contras[] = new String[100]; 
    static int totalUsuarios = 0; 
    static int Jactual;

    public void nuevo() {
        Menu_Inicio m = new Menu_Inicio();
        JFrame nu = new JFrame();
        nu.setSize(500, 500);
        nu.setLocationRelativeTo(null);
        nu.setLayout(null);

        JLabel tt = new JLabel("NUEVO USUARIO");
        tt.setBounds(150, 50, 200, 50);
        tt.setFont(new Font("Arial", Font.BOLD, 23));
        tt.setForeground(Color.BLACK); 

        JTextField usuario = new JTextField();
        usuario.setBounds(200, 150, 200, 35);

        JTextField contra = new JTextField();
        contra.setBounds(200, 200, 200, 35);

        JLabel txtu = new JLabel("Usuario:");
        txtu.setBounds(100, 150, 100, 35);

        JLabel txtc = new JLabel("Contraseña:");
        txtc.setBounds(100, 200, 100, 35);

        JButton regresar = new JButton("REGRESAR");
        regresar.setBounds(250, 330, 120, 40);
        regresar.addActionListener(e -> {
            m.menui();      
            nu.dispose();
        });

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(100, 330, 120, 40);
        aceptar.addActionListener(e -> {
            String user = usuario.getText();
            String pass = contra.getText();  

            
            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(nu, "Complete todos los campos");
                return;
            }

            if (pass.length() == 5) {
                
            
            if (revU(0, user, pass)) {
                noms[totalUsuarios] = user;     
                contras[totalUsuarios] = pass;  
                totalUsuarios++;                
                JOptionPane.showMessageDialog(nu, "¡Usuario registrado!");
                m.menui();
                nu.dispose();
            } else {
                JOptionPane.showMessageDialog(nu, "¡Ese usuario ya existe!");
            }
}else{
        JOptionPane.showMessageDialog(nu, "La contraseña  debe ser de 5 caracteres exactos");
        return;
            }
        });

        nu.add(aceptar);
        nu.add(regresar);
        nu.add(txtu);
        nu.add(txtc);
        nu.add(tt);
        nu.add(contra);
        nu.add(usuario);
        nu.setVisible(true);
        
        Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
    Image imgEscalada = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
    fondo.setBounds(0, 0, 500, 500);
    nu.add(fondo); 

    nu.setVisible(true);
    }

    public boolean revU(int a, String usu, String contra) {
        
        if (a >= totalUsuarios) { 
            return true;
        }
       
        if (noms[a].equals(usu)) {
            return false;
        }
        
        return revU(a + 1, usu, contra);
    }
    
   public boolean verificar(int a, String usu, String contra) {
    
    if (a < 0) {
        return false;
    }
    if (noms[a].equals(usu) && contras[a].equals(contra)) {
        Jactual = a;
        return true;
    }
    return verificar(a - 1, usu, contra);
}
    
    public void MICUENTA() {
    JFrame datos = new JFrame();
    datos.setSize(500, 500);
    datos.setLayout(null);
    datos.setLocationRelativeTo(null);
    datos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel da = new JLabel("MI CUENTA");
    da.setBounds(150, 50, 250, 50);
    da.setFont(new Font("Arial", Font.BOLD, 23));
    da.setForeground(Color.BLACK); // 👈 Sin corchetes

    JButton cc = new JButton("Cambiar su contraseña");
    cc.setBounds(150, 200, 180, 40);
    cc.addActionListener(e -> {
        cambio();
        datos.dispose(); 
    });

    JButton cerrar = new JButton("Cerrar Cuenta");
    cerrar.setBounds(150, 260, 180, 40);
    cerrar.addActionListener(e -> {
        cerrar();
        datos.dispose(); 
    });

    JButton regresar = new JButton("REGRESAR");
    regresar.setBounds(150, 320, 180, 40);
    regresar.addActionListener(e -> {
        datos.dispose();
        Menu a = new Menu();
        a.menuj();
    });

    datos.add(regresar);
    datos.add(cerrar);
    datos.add(cc);
    datos.add(da);
    datos.setVisible(true);
    
    Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
    Image imgEscalada = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
    fondo.setBounds(0, 0, 500, 500);
    datos.add(fondo); 

    datos.setVisible(true);
}
    
   public void cambio() {
    JFrame tt = new JFrame("Cambiar Password");
    tt.setSize(500, 500);
    tt.setLayout(null);
    tt.setLocationRelativeTo(null);
    tt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel titulo = new JLabel("Cambiar Password");
    titulo.setBounds(150, 30, 250, 50);
    titulo.setFont(new Font("Arial", Font.BOLD, 23));
    titulo.setForeground(Color.BLACK);

    
    JLabel lbActual = new JLabel("Password actual:");
    lbActual.setBounds(80, 150, 150, 35);

    JTextField actual = new JTextField();
    actual.setBounds(230, 150, 180, 35);

    
    JLabel lbNuevo = new JLabel("Nuevo password:");
    lbNuevo.setBounds(80, 210, 150, 35);

    JTextField nuevo = new JTextField();
    nuevo.setBounds(230, 210, 180, 35);

    JButton regresar = new JButton("REGRESAR");
    regresar.setBounds(250, 330, 120, 40);
    regresar.addActionListener(e -> {
        MICUENTA();
        tt.dispose();
    });

    JButton aceptar = new JButton("ACEPTAR");
    aceptar.setBounds(100, 330, 120, 40);
    aceptar.addActionListener(e -> {
        String actual_c = actual.getText();
        String nuevo_c = nuevo.getText();

        
        if (actual_c.isEmpty() || nuevo_c.isEmpty()) {
            JOptionPane.showMessageDialog(tt, "Complete todos los campos");
            return;
        }

       
        if (!contras[Jactual].equals(actual_c)) {
            JOptionPane.showMessageDialog(tt, "El password actual es incorrecto");
            return;
        }

       
        if (nuevo_c.length() != 5) {
            JOptionPane.showMessageDialog(tt, "El nuevo password debe tener exactamente 5 caracteres");
            return;
        }


        contras[Jactual] = nuevo_c;
        JOptionPane.showMessageDialog(tt, "¡Password cambiado exitosamente!");
        tt.dispose(); 
    });

    tt.add(titulo);
    tt.add(lbActual);
    tt.add(actual);
    tt.add(lbNuevo);
    tt.add(nuevo);
    tt.add(aceptar);
    tt.add(regresar);
    tt.setVisible(true);
    
    Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
    Image imgEscalada = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
    fondo.setBounds(0, 0, 500, 500);
    tt.add(fondo); 

    tt.setVisible(true);
}
    public void cerrar() {
    JFrame ce = new JFrame("Eliminar Cuenta");
    ce.setSize(500, 500);
    ce.setLayout(null);
    ce.setLocationRelativeTo(null);
    ce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel titulo = new JLabel("Eliminar Cuenta");
    titulo.setBounds(150, 50, 250, 50);
    titulo.setFont(new Font("Arial", Font.BOLD, 23));
    titulo.setForeground(Color.BLACK);

    JLabel nc = new JLabel("Confirma tu contraseña:");
    nc.setBounds(80, 150, 180, 35);

    JTextField contra = new JTextField();
    contra.setBounds(250, 150, 180, 35);

    JButton regresar = new JButton("REGRESAR");
    regresar.setBounds(250, 330, 120, 40);
    regresar.addActionListener(e -> {
        MICUENTA();
        ce.dispose();
    });

    JButton eliminar = new JButton("ELIMINAR");
    eliminar.setBounds(100, 330, 120, 40);
    eliminar.addActionListener(e -> {
        String c = contra.getText();

        if (c.isEmpty()) {
            JOptionPane.showMessageDialog(ce, "Ingrese su contraseña");
            return;
        }

        
        if (contras[Jactual].equals(c)) {

            
            for (int i = Jactual; i < totalUsuarios - 1; i++) {
                noms[i] = noms[i + 1];
                contras[i] = contras[i + 1];
            }

            noms[totalUsuarios - 1] = null;
            contras[totalUsuarios - 1] = null;
            totalUsuarios--;       
            Jactual = -1;    

            JOptionPane.showMessageDialog(ce, "¡Cuenta eliminada!");
            ce.dispose(); 
            

        } else {
            JOptionPane.showMessageDialog(ce, "Contraseña incorrecta");
        }
    });

    ce.add(titulo);
    ce.add(nc);
    ce.add(contra);
    ce.add(eliminar);
    ce.add(regresar);
    ce.setVisible(true);
    
    Image img = new ImageIcon("src/ajedrez_chino/Image/FotoAjedrez.png").getImage();
    Image imgEscalada = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
    JLabel fondo = new JLabel(new ImageIcon(imgEscalada));
    fondo.setBounds(0, 0, 500, 500);
    ce.add(fondo); 

    ce.setVisible(true);
}
}
