/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Ventanas.Gestor2;

/**
 *
 * @author Daniel Camacho
 */
public class Right implements Runnable
{
private final Gestor2 gestor;
private int Navx;

public Right(Gestor2 gest)
{
    this.gestor=gest;
    this.Navx=gestor.getGame().getNavx();
}
    

    @Override
    public void run() 
    {
        System.out.println("Right");
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
