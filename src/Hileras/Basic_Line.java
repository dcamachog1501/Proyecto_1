/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hileras;

import Enemigos.Basic;
import Enemigos.Enemy;
import Fabrica_Enemigos.Basic_Creator;
import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Daniel Camacho
 */
public class Basic_Line implements Line
{
    private Basic Head;
    private int len;
    private int lenmax;
    private int enmx;
    private int enmy;
    private int sup;
    private int inf;
    private Basic_Creator fabrica;
    private Image current;
    private Gestor2 gestor;
    private Line next;
    @Override
    public void setFactory()
    {
        this.fabrica=new Basic_Creator();
    }
    @Override
    public boolean isEmpty()
    {
         if(this.len==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override 
    public void Init(Gestor2 gest)
    {
        this.setCurrent();
        this.setEnmx();
        this.setEnmy();
        this.setHead();
        this.setInf();
        this.setLen();
        this.setMaxlen();
        this.setSup();
        this.setGestor(gest);
        this.setFactory();
        this.next=null;
    }
    @Override
    public void adder(Object enm)
    {
        if(isEmpty()==true)
        {
            this.Head=(Basic) enm;
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
                    temp=(Basic) temp.getNext();

                }
            }
        }
    }
    @Override
    public Image getCurrent()
    {
        return current;
    }
    @Override
    public void createLine()
    {
      while(len<lenmax)
      {
          Enemy enm=fabrica.createEnemy(this.getEnmx(),this.getEnmy(),this.getSup(),this.getInf());
          this.adder(enm);
          enmx-=100;
          inf-=100;
      }
    }
    @Override
    public int getInf()
    {
        return inf;
    }
    @Override
    public int getSup()
    {
        return sup;
    }
    @Override
    public void Render(Graphics g,Canvas c)
    {
       Basic temp=this.Head;
       while(temp!=null)
       {
           g.drawImage(temp.getFace(),temp.getX(),temp.getY(),c);
           temp=(Basic) temp.getNext();
           
       }
    }
    @Override
    public int getEnmy()
    {
        return enmy;
    }
    @Override
    public int getEnmx()
    {
        return enmx;
    }
    @Override
    public Basic getHead()
    {
        return Head;
    }
    @Override
    public void eliminate(int x)
    {
       Basic temp= this.getHead();
       int ind=0;
       while(temp!=null)
       {
           if(x==0)
           {
               this.Head=(Basic) temp.getNext();
               //this.elim+=1;
               
               break;
           }
           else if(ind+1==x)
           {
               temp.setNext(temp.getNext().getNext());
               //this.elim+=1;
               break;
           }
           else
           {
           ind++;
           temp=temp.getNext();
           }
       }
    }

    @Override
    public void setHead() 
    {
        this.Head=null;
    }

    @Override
    public void setLen() 
    {
        this.len=0;
    }

    @Override
    public void setMaxlen() 
    {
        this.lenmax=7;
    }

    @Override
    public void setEnmx() 
    {
        this.enmx=660;
    }

    @Override
    public void setEnmy() 
    {
        this.enmy=200;
    }

    @Override
    public void setSup() 
    {
        this.sup=910;
    }

    @Override
    public void setInf() 
    {
        this.inf=630;
    }

    @Override
    public void setCurrent() 
    {
        this.current=Toolkit.getDefaultToolkit().getImage("Resources/Current Icons/Basic.png");
    }

    @Override
    public void setGestor(Gestor2 gest) 
    {
        this.gestor=gest;
    }

    @Override
    public void setNext(Line l) 
    {
        this.next=l;
    }

    @Override
    public Line getNext() 
    {
        return this.next;
    }

}
