/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.*;

/**
 *
 * @author Curso
 */
public class Bullet 
{
    private  final Image Shoot=Toolkit.getDefaultToolkit().getImage("Resources/disparos/Shoot.png");
    private  int Bullx=Juego.getX()+17;
    private  int Bully=Juego.getY();
    private  int cond;
    public Bullet()
    {
        Image Bull=Shoot;
        
    }
   public  int getBullY()
   {
       return Bully;
   }
   public  int getBullX()
   {
       return Bullx;
   }
   public  void setY(int y)
   {
       Bully+= y;
   }
   public  void setX()
   {
       Bullx=Juego.getX()+17;
   }
   public  Image getImage(){
       return Shoot;
   }
   public int getCond()
   {
       return cond;
   }
   public void setCond()
   {
       if(cond==0)
       {
           cond=1;
       }
       cond=0;
   }

    
}
