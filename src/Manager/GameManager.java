/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Componentes_Jugador.Nave;
import Componentes_Jugador.Bullet;
import Enemigos.Basic_Line_Creator;
import Threads.BasicMove;
import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Daniel Camacho 
 * 
 */
public class GameManager 
{
    private Gestor2 gestor;
    private Nave nave;
    private Bullet bala;
    private boolean cond;
    private Basic_Line_Creator basic;
    private Thread move;
    
    public GameManager()
    {
        
    }
    public GameManager(Gestor2 gest)
    {
        this.gestor=gest;
        this.nave=new Nave(gestor);
        this.bala=new Bullet(gestor,nave.getNavx(),nave.getNavy());
        basic=new Basic_Line_Creator();
        basic.createLine();
        move=new Thread(new BasicMove());
    }
    public void render(Graphics g)
    {
        System.out.println("Drawing");
        basic.Render(g,gestor.getGame().getCanvas());
        if (cond==false)
        {
        nave.render(g);
        }
        else
        {
        System.out.println("Shooting");
        nave.render(g);
        bala.Render(g);
        }
        move.start();
    }
    public Nave getNav()
    {
        return nave;
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
   public Bullet getBull()
   {
       return bala;
   }
   public Basic_Line_Creator getBasic()
   {
       return basic;
   }
}
