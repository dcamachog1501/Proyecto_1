/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Ventanas.V_Datos;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Daniel Camacho
 */
public class Canv extends JComponent

{
 private Boolean cond=false;   
 private final Bullet bala= new Bullet();
    public Canv()
      {
          setPreferredSize(new Dimension(985,670)); 
          
   
      }
      @Override
      public void paint(Graphics g)
      {
          if (cond==false)
          {
          g.drawImage(V_Datos.getNav(),Juego.getX(),Juego.getY(),this);
          }
          else if (cond==true)
          {
          g.drawImage(V_Datos.getNav(),Juego.getX(),Juego.getY(),this);
          g.drawImage(bala.getImage(),bala.getBullX(),bala.getBullY(),this);
          }
      }
    public void setCond()
    {
        if(cond!=true)
        {
            cond=true;
            repaint();
        }
        else
        {
            cond=false;
            repaint();
        }
    }
    public Bullet getBullet()
    {
        return bala;
    }

}
