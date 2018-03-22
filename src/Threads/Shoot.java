/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

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
        this.Navx=gestor.getGame().getNavx();
        this.Navy=gestor.getGame().getNavy();
        this.set=gestor.getDatos().getSet();
        this.tec2=gestor.getGame().getTec();
    }        
    @Override
    public void run() 
    {
        set.chanCond();
        gestor.getGame().rem();
        gestor.getGame().getBull().setBullx(0);
        gestor.getGame().getBull().setBullx(Navx+17);
        while(gestor.getGame().getBull().getBullY()>0)
        {
            try {
                gestor.getGame().getBull().setBully(-25);
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        gestor.getGame().getBull().setBully(Navy);
        set.chanCond();
        gestor.getGame().adder();
    }
    
}
