/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import java.awt.*;

/**
 *
 * @author Daniel Camacho
 */
public class Basic 
{
   private Basic next;
   private Image face;
   private int enx;
   private int eny;
   private final int health;
   private int dir=1;
   private Rectangle rec;
   Basic(int x, int y)
   {
       this.enx=x;
       this.eny=y;
       this.health=1;
       this.next=null;
       this.face=Toolkit.getDefaultToolkit().getImage("Resources/Enemigos/Basic.png");
       this.rec= new Rectangle(enx,eny,64,64);
   }
   public void setNext(Basic enm)
   {
       this.next=enm;
   }
   public Basic getNext()
   {
       return this.next;
   }
   public int getX()
   {
       return this.enx;
   }
   public int getY()
   {
       return this.eny;
   }
   public Image getFace()
   {
       return this.face;
   }
   public void chnX()
   {
       if(dir==1)
       {
         this.enx-=50;
       }
       else
       {
           this.enx+=30;
       }
   }
   public void chnY()
   {
       this.eny+=25;
   }
   public void chnDir()
   {
       if(dir==1)
       {
           dir=0;
       }
       else
       {
           dir=1;
       }
   }
   public Rectangle getRec()
   {
       return rec;
   }
   public void chnFace()
   {
       this.face=null;
   }
   public void chnRec()
   {
       this.rec= new Rectangle(this.getX(),this.getY(),64,64);
   }
}
