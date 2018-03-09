/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Toolkit;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
   
public Gestor()
{
 
}
public Gestor(int Largo,int Ancho)
{
    this.Largo=Largo;
    this.Ancho=Ancho;
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
  Ventana.setSize((Ventana_Inicial.vent.getLargo()),(Ventana_Inicial.vent.getAncho()));
  Ventana.setVisible(true);
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
