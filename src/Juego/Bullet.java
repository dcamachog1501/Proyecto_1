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
    private static final Image Shoot=Toolkit.getDefaultToolkit().getImage("Resources/disparos/Shoot.png");
    private static final int Bullx=Juego.getX();
    private static int Bully=Juego.getY();
    public Bullet()
    {
        Image Bull=Shoot;
        
    }
   public static int getBullY()
   {
       return Bully;
   }
   public static int getBullX()
   {
       return Bullx;
   }
   public static void setY(int y)
   {
       Bully+= y;
   }
   public static Image getImage(){
       return Shoot;
   }
}
