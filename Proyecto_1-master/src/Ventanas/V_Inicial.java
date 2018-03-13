/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Daniel Camacho
 */
public class V_Inicial extends Gestor
{
private final Image Back=Toolkit.getDefaultToolkit().getImage("Resources/Background.jpg");
    public V_Inicial()
    {
      JFrame Ventana = new JFrame(Titulo);
      Ventana.setResizable(false);
      Ventana.setUndecorated(true);
      Ventana.setIconImage(Icono);
      Ventana.setSize(600,700);
      Ventana.setLocationRelativeTo(null);
      Ventana.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,Color.BLACK));
      JLabel Uno= new JLabel(new ImageIcon(Back));
      Uno.setLayout(new BoxLayout(Uno,BoxLayout.Y_AXIS));
      
      JLabel Title= new JLabel("Invaders");
      Title.setFont(FuenteTitulo.deriveFont(Font.PLAIN,80));
      Title.setForeground(Color.GREEN);
      Title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      Uno.add(Title);
     

      JLabel Icon=new JLabel();
      Icon.setIcon(new ImageIcon(("Resources/Icono2.png")));
      Icon.setHorizontalAlignment(JLabel.CENTER);
      Icon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      Uno.add(Icon);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      JButton Jugar= new JButton("¡JUGAR!");
      Jugar.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
      Jugar.setForeground(Btn);
      Jugar.setBackground(Color.GREEN);
      Jugar.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Jugar.setMaximumSize(new Dimension(300,100));
      Jugar.setFocusPainted(false);
      Jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Jugar.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Uno.add(Jugar);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      JButton Estadísticas= new JButton("Estadisticas");
      Estadísticas.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
      Estadísticas.setForeground(Btn);
      Estadísticas.setBackground(Color.GREEN);
      Estadísticas.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Estadísticas.setMaximumSize(new Dimension(300,100));
      Estadísticas.setFocusPainted(false);
      Estadísticas.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Estadísticas.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Uno.add(Estadísticas);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      JButton Salir= new JButton("Salir");
      Salir.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
      Salir.setForeground(Btn);
      Salir.setBackground(Color.GREEN);
      Salir.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Salir.setMaximumSize(new Dimension(300,100));
      Salir.setFocusPainted(false);
      Salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Salir.addActionListener(new Exit());
      Salir.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Uno.add(Salir);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      Ventana.add(Uno,BorderLayout.CENTER);
      Ventana.setVisible(true);
         
    }
    
    static class Exit implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }

    }
}

