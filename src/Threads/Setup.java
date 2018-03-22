/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Ventanas.Gestor2;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 *
 * @author dcama
 */
public class Setup implements Runnable
{
    private Thread update;
    private boolean runnig;
    private Gestor2 gestor;
    private BufferStrategy buffer;
    private Graphics g;
    private final Image Nav1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave1.png");
    private int Navx;
    private boolean cond;
    public Setup()
    {
        
    }
    
    public Setup(Gestor2 g)
    {
        gestor = g;
        Navx=gestor.getGame().getNavx();
        cond=false;
    }
    
    public void init()
    {
        System.out.println("Initialized");
        gestor.gestJuego();
    }
    public synchronized void start()
    {
        if (runnig)
            return;
            runnig=true;
        if (update== null)
        {
        update= new Thread(this);
        update.start();
        }
    }
    public synchronized void stop()
    {
        if(!runnig)
            return;
            runnig=false;
        try {
            update.join();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void tick()
    {
        
    }
    public void render()
    {
        System.out.println("rendering");
        buffer=gestor.getGame().getCanvas().getBufferStrategy();
        if(buffer==null)
                {
                    gestor.getGame().getCanvas().createBufferStrategy(3);
                    System.out.println(gestor.getGame().getBufferStrategy());
                    return;
                }
        g=buffer.getDrawGraphics();
        g.clearRect(0,0,985,670);
        // inicio de graficacion
        System.out.println("Drawing");
        if (cond==false)
        {
        g.drawImage(gestor.getDatos().getNav(),gestor.getGame().getNavx(),gestor.getGame().getNavy(),gestor.getGame().getCanvas());
        }
        else
        {
        System.out.println("Shooting");
        g.drawImage(gestor.getDatos().getNav(),gestor.getGame().getNavx(),gestor.getGame().getNavy(),gestor.getGame().getCanvas());
        g.drawImage(gestor.getGame().getBull().getImage(),gestor.getGame().getBull().getBullX(),gestor.getGame().getBull().getBullY(),gestor.getGame().getCanvas());
        }
        //fin de graficacion
        buffer.show();
        g.dispose();
    }
  
    public void run()
    {
       init();
       int fps= 60;
       double TimeperTick=1000000000/fps;
       double delta=0;
       long current=System.nanoTime();
       while(runnig)
       {
           delta=delta+((System.nanoTime())-current)/TimeperTick;
           current=System.nanoTime();
           if(delta>=1)
           {
               System.out.println("FPS: "+fps);
              tick();
              render(); 
              delta--;
           }
           
       }
    }
    public void chanCond()
    {
        if(cond==false)
        {
            cond=true;
        }
        else
        {
            cond=false;
        }
    }
    public void Right()
    {
        if(gestor.getGame().getNavx()<920)
              {
               gestor.getGame().chnNavx(Navx+20);
              }
        else
              {
              gestor.getGame().chnNavx(920);
              }
    }
    
}
