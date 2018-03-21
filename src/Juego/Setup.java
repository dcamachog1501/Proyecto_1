/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

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
    private static Gestor2 gestor=new Gestor2();
    private BufferStrategy buffer;
    private Graphics g;
    private Image Nav1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave1.png");
    public Setup()
    {
        
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
        buffer=gestor.getCanvas().getBufferStrategy();
        if(buffer==null)
                {
                    gestor.getCanvas().createBufferStrategy(3);
                    return;
                }
        g=buffer.getDrawGraphics();
        g.clearRect(0,0,985,670);
        // inicio de graficacion
        System.out.println("Drawing");
        g.drawImage(gestor.getNav(),gestor.getNavx(),gestor.getNavy(),gestor.getCanvas());
        
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
    public static Gestor2 getGest()
    {
        return gestor;
    }
    
}
