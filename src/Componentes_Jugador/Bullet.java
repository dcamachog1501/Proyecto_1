/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes_Jugador;

import Ventanas.Gestor2;
import java.awt.*;

/**
 *
 * @author Curso
 */
public class Bullet
{
    private final Image Shoot=Toolkit.getDefaultToolkit().getImage("Resources/disparos/Shoot.png");
    private final Gestor2 gestor;
    private int Bullx;
    private int Bully;
    public Bullet(Gestor2 gest,int x, int y)
    {
        this.gestor=gest;
        this.Bullx=x;
        this.Bully=y;
    }
    public void Render(Graphics g)
    {
      g.drawImage(Shoot, Bullx, Bully,gestor.getGame().getCanvas());
    }
    public void chnBullx(int x)
    {
        Bullx+=x;
    }
    public void chnBully(int y)
    {
        Bully+=y;
    }
    public void setBullx(int x)
    {
        Bullx=x;
    }
    public void setBully(int y)
    {
        Bully=y;
    }
    public int getBullx()
    {
        return Bullx;
    }
    public int getBully()
    {
        return Bully;
    }

}   
