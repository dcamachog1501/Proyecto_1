/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
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
   private int Largo;
   private int Ancho;
   private  Font FuenteTitulo;





    public Gestor()
    {
        try {
        FuenteTitulo = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Furore.ttf")).deriveFont(Font.PLAIN,99);
        } catch(Exception e) {
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
  Ventana.setLocationRelativeTo(Ventana);
  Ventana.getContentPane().setBackground(Color.DARK_GRAY);
  Ventana.setVisible(true);
  
  JPanel Posterior= new JPanel();
  Posterior.setBackground(Color.DARK_GRAY);
  Posterior.setLayout(new GridBagLayout());
  GridBagConstraints lbl1= new GridBagConstraints();
  Ventana.add(Posterior);
  
  JLabel Title= new JLabel("Invaders");
  Title.setFont(FuenteTitulo);
  Title.setForeground(Color.GREEN);
  lbl1.gridx=100;
  lbl1.gridy=200;
  Posterior.add(Title,lbl1);
  
  
  
  JLabel Icon=new JLabel();
  Icon.setIcon(new ImageIcon(("Resources/Icono.png")));
  //Ventana.add(Icon);
}
/**
 * Metodo que retorna el valor del ancho de una ventana
 * @return 
 */
public int getAncho()
{
    return this.Ancho;
}
public int getLargo()
{
    return this.Largo;
}
}
