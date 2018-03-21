/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Curso
 */
public class Bullet
{
    private  final Image Shoot=Toolkit.getDefaultToolkit().getImage("Resources/disparos/Shoot.png");
    private  int Bullx;                                                      
    private  int Bully;
    private  int cond;
    
    public Bullet(int x, int y)
    {
        Bullx=x;
        Bully=y;
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
       Bully-= y;
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
       else
       {
       cond=0;
       }
   }
   public void setBully(int y)
   {
       Bully=y;
   }
   public void setBullx(int x)
   {
       Bullx=x;
   }

    
}
