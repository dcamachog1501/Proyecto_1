/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Ventanas.Gestor;
import Ventanas.V_Datos;
import Ventanas.V_Estadistica;
import java.awt.*;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author dcama
 */
public class Juego extends JFrame 
{
  private Canv Canvas=new Canv();
  private Font FuenteMarc;
  public Juego() 
  {
    try
    {
        FuenteMarc= Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Marcador.ttf"));
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    setTitle(Gestor.getTitle());
    setSize(1300,700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setUndecorated(true);
    setLocationRelativeTo(null);
    getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.BLACK));
    setResizable(false);
    setIconImage(Gestor.getIcon());
    setFocusable(true);
    
    add(Canvas,BorderLayout.EAST);
    
    JPanel Panel1= new JPanel();
    Panel1.setPreferredSize(new Dimension(300,1000));
    Panel1.setBackground(Color.DARK_GRAY);
    Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,8,Color.BLACK));
    add(Panel1,BorderLayout.WEST);
    
    JLabel Punt= new JLabel(" 0000000000000");
    Punt.setBackground(Gestor.getColor());
    Punt.setOpaque(true);
    Punt.setBorder(BorderFactory.createMatteBorder(4,0,8,0, Color.BLACK));
    Punt.setBounds(0,0,292,75);
    Punt.setForeground(Color.GREEN);
    Punt.setFont(FuenteMarc.deriveFont(Font.PLAIN,20));
    Panel1.setLayout(null);
    Panel1.add(Punt);
    
    JLabel Punt2= new JLabel();
    Punt2.setBackground(Color.BLACK);
    Punt2.setOpaque(true);
    Punt2.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.DARK_GRAY));
    Punt2.setBounds(0,75,292,250);
    Punt2.setForeground(Color.GREEN);
    Panel1.add(Punt2);
    
    JLabel Punt3= new JLabel();
    Punt3.setBackground(Color.BLACK);
    Punt3.setOpaque(true);
    Punt3.setBounds(0,325,292,8);
    Panel1.add(Punt3);
    
    JLabel Punt4= new JLabel("CURRENT ");
    Punt4.setBounds(5,210,292,292);
    Punt4.setForeground(Color.GREEN);
    Punt4.setFont(FuenteMarc.deriveFont(Font.PLAIN,15));
    Panel1.add(Punt4);
    
    JLabel Punt5= new JLabel("NEXT ");
    Punt5.setBounds(5,280,292,292);
    Punt5.setForeground(Color.GREEN);
    Punt5.setFont(FuenteMarc.deriveFont(Font.PLAIN,15));
    Panel1.add(Punt5);
    
    JButton Abort= new JButton("Abort");
    Abort.setForeground(Color.GREEN);
    Abort.setBackground(Gestor.getColor());
    Abort.setFont(Gestor.getFont().deriveFont(Font.PLAIN,20));
    Abort.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
    Abort.setFocusPainted(false);
    Abort.setBounds(48,550, 200, 70);
    Panel1.add(Abort);
    
    JLabel Punt7= new JLabel("LEVEL ");
    Punt7.setBounds(5,350,292,292);
    Punt7.setForeground(Color.GREEN);
    Punt7.setFont(FuenteMarc.deriveFont(Font.PLAIN,15));
    Panel1.add(Punt7);
    
    JLabel Punt6= new JLabel();
    Punt6.setIcon(new ImageIcon(V_Estadistica.getBack2()));
    Punt6.setBounds(0,320,292,500);
    Panel1.add(Punt6); 
  }
  private class Canv extends Canvas
  {
      private int Navx=460;
      private int Navy=615;
      public Canv()
      {
          setBackground(Color.DARK_GRAY);
          this.setPreferredSize(new Dimension(985,670));
          setFont(Gestor.getFont().deriveFont(Font.PLAIN, 20));
          setForeground(Color.GREEN);
          
      }
      @Override
      public void paint(Graphics g)
      {
          g.drawImage(V_Datos.getNav(),Navx,Navy,this);
      }
  }
  
}
