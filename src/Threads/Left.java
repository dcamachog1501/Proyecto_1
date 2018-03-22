/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Ventanas.Gestor2;

/**
 *Clase de tipo Thread encargada de modificar las coordenadas en x de la nave
 * @author Daniel Camacho
 */
public class Left implements Runnable 
{
private final Gestor2 gestor;
private int Navx;

public Left(Gestor2 gest)
{
    this.gestor=gest;
    this.Navx=gestor.getGame().getNavx();
}
    

    @Override
    public void run() 
    {
        System.out.println("Left");
      if(gestor.getGame().getNavx()>0)
              {
               gestor.getGame().chnNavx(Navx-20);
              }
      else
              {
              gestor.getGame().chnNavx(0);
              }
    }
    
}
