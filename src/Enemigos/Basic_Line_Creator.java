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
public class Basic_Line_Creator 
{
    private Basic Head;
    private int len;
    private final int lenmax;
    private int enmx;
    private int enmy;
    public Basic_Line_Creator()
    {
     this.Head=null;
     this.len=0;
     this.lenmax=7;
     this.enmx=660;
     this.enmy=200;
    }
    public int isEmpty()
    {
        return len;
    }
    public void adder(Basic enm)
    {
        if(isEmpty()==0)
        {
            this.Head=enm;
            len++;
        }
        else
        {
            Basic temp=this.Head;
            while(temp!=null)
            {
                if(temp.getNext()==null)
                {
                    temp.setNext(enm);
                    len++;
                    break;
                }
                else
                {
                    temp=temp.getNext();

                }
            }
        }
    }
    public void createLine()
    {
      while(len<lenmax)
      {
          this.adder(new Basic(enmx,enmy));
          enmx-=100;
      }
    }
    public void Render(Graphics g,Canvas c)
    {
       Basic temp=this.Head;
       while(temp!=null)
       {
           g.drawImage(temp.getFace(),temp.getX(),temp.getY(),c);
           temp=temp.getNext();
           
       }
    }
    public int getEnmy()
    {
        return enmy;
    }
    public Basic getHead()
    {
        return Head;
    }
}
