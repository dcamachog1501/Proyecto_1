/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dcama
 */
public class Gestor 
{
   private final String Titulo="Invaders";
   private final String Icono="";
   private  Font FuenteTitulo;
   private final Color Btn=new Color(75,0,130);
    public Gestor()
    {
        try 
        {
        FuenteTitulo = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Furore.ttf"));
        
        } 
        catch(Exception e) 
        {
            FuenteTitulo = null;
        }
    }


    /**
     * Metodo encargado de determinar cual ventana se despliega
     * @param x Numero de ventana a desplegar
     */
    public void GestWindow(int x)
    {
        switch(x)
        {
            case(1):
            {
             Inicial_Creator();
            }
        }
    }


    /**
     * Metodo que crea la ventana inicial.
     */
    public void Inicial_Creator()
    {


      JFrame Ventana = new JFrame(Titulo);
      Ventana.setResizable(false);
      Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Ventana.setIconImage(Toolkit.getDefaultToolkit().getImage("Resources/Icono.png"));
      Ventana.setSize(800,700);
      Ventana.setLocationRelativeTo(null);
      Ventana.setBackground(Color.DARK_GRAY);

      JPanel Uno= new JPanel();
      Uno.setBackground(Color.DARK_GRAY);
      JPanel Dos= new JPanel();
      Dos.setBackground(Color.DARK_GRAY);
      Dos.setLayout(new GridLayout(5,1));
      
      JLabel Title= new JLabel("Invaders");
      Title.setFont(FuenteTitulo.deriveFont(Font.PLAIN,80));
      Title.setForeground(Color.GREEN);
      Uno.add(Title);
      

      JLabel Icon=new JLabel();
      Icon.setIcon(new ImageIcon(("Resources/Icono2.png")));
      Icon.setHorizontalAlignment(JLabel.CENTER);
      Dos.add(Icon);
      
      JButton Jugar= new JButton("¡JUGAR!");
      Jugar.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
      Jugar.setForeground(Btn);
      Jugar.setBackground(Color.GREEN);
      Jugar.setPreferredSize(new Dimension(200,200));
      Dos.add(Jugar);
      
      Ventana.add(Uno,BorderLayout.NORTH);
      Ventana.add(Dos,BorderLayout.CENTER);
      Ventana.setVisible(true);
    }
}
