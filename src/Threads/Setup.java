/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Enemigos.Basic;
import Enemigos.Basic_Line_Creator;
import Manager.GameManager;
import Ventanas.Gestor2;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 *
 * @author Daniel Camacho 
 */
public class Setup implements Runnable
{
    private GameManager manager;
    private Thread update;
    private boolean runnig;
    private Gestor2 gestor;
    private BufferStrategy buffer;
    private Graphics g;
    private double TimeperTick;
    public Setup()
    {
        
    }
    
    public Setup(Gestor2 g)
    {
        gestor = g;
    }
    
    public void init()
    {
        System.out.println("Initialized");
        gestor.gestJuego();
        manager=new GameManager(gestor);
        
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
        
        manager.render(g);
        
        //fin de graficacion
        buffer.show();
        g.dispose();
    }
  
    public void run()
    {
       init();
       int fps= 60;
       TimeperTick=1000000000/fps;
       double delta=0;
       long current=System.nanoTime();
       while(runnig)
       {
           delta=delta+((System.nanoTime())-current)/TimeperTick;
           current=System.nanoTime();
           if(delta>=1)
           {
              System.out.println("FPS: "+fps);
              render(); 
              delta--;
           }
           
       }
    }
    public GameManager getMan()
    {
        return manager;
    }
    public double getTime()
    {
        return TimeperTick;
    }
    
}
