/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Componentes_Jugador.Nave;
import Componentes_Jugador.Bullet;
import Enemigos.Basic_Line_Creator;
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
    
    
    public GameManager()
    {
        
    }
    public GameManager(Gestor2 gest,Bullet bala,Nave nave)
    {
        this.gestor=gest;
        this.nave=nave;
        this.bala=bala;
        
    }
    public void render(Graphics g)
    {
        System.out.println("Drawing");
        gestor.getGame().getBasic().Render(g,gestor.getGame().getCanvas());
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
   
}
