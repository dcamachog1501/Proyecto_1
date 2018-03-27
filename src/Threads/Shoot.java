/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Componentes_Jugador.Bullet;
import Enemigos.Basic;
import Ventanas.Gestor2;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Camacho
 */
public class Shoot implements Runnable
{
    private final Gestor2 gestor;
    private int Navx;
    private int Navy;
    private Setup set;
    private KeyListener tec2;
    public Shoot(Gestor2 gest)
    {
        this.gestor=gest;
        this.Navx=gestor.getDatos().getSet().getNave().getNavx();
        this.Navy=gestor.getDatos().getSet().getNave().getNavy();
        this.set=gestor.getDatos().getSet();
        this.tec2=gestor.getGame().getTec();
    }        
    @Override
    public void run() 
    {
        gestor.getGame().chanCond();
        gestor.getGame().rem();
        set.getBull().setBullx(0);
        set.getBull().setBullx(Navx+17);
        while(set.getBull().getBully()>0)
        {
            Basic temp=gestor.getGame().getBasic().getHead();
            int ind=0;
            while(temp!=null)
            {
                Bullet b=set.getBull();
                if(b.getBullx()<temp.getX()+64&& b.getBullx()+24>temp.getX()
                   && b.getBully()<temp.getY()+64&&b.getBully()+24> temp.getY())
                {
                    System.out.println("Killing");
                    gestor.getGame().getBasic().eliminate(ind);
                    break;
                }
                temp=temp.getNext();
                ++ind;
            }
            
            try {
                set.getBull().chnBully(-25);
                Thread.sleep(10);
                }   
                catch (Exception e) 
                {
                e.printStackTrace();
                }
        }
        set.getBull().setBully(Navy);
        gestor.getGame().chanCond();
        gestor.getGame().adder();
    }
    
}
