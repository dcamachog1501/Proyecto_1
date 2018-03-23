/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Enemigos.Basic_Line_Creator;
import Enemigos.Basic;
import Ventanas.Gestor2;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Camacho 
 */
public class BasicMove implements Runnable
{
    private Basic_Line_Creator hilera;
    private Basic temp;
    public BasicMove()
    {
        
    }
    public BasicMove(Basic_Line_Creator hilera)
    {
        this.hilera=hilera;
        
    }
    @Override
    public void run() 
    {
            if(hilera.getHead().getX()<=430)
            {
                temp=hilera.getHead();
                while(temp!=null)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                }
            }
            if(hilera.getHead().getX()>=910)
            {
                temp=hilera.getHead();
                while(temp!=null)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                }
            }
            else
            {
                temp=hilera.getHead();
                while(temp!=null)
                {
                    temp.chnX();
                    temp=temp.getNext();
                }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(BasicMove.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
