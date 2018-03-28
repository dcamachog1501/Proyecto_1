
package Threads;

import Componentes_Jugador.Bullet;
import Enemigos.Basic_Line_Creator;
import Enemigos.Basic;
import Ventanas.Gestor2;

/**
 *
 * @author Daniel Camacho 
 */
public class BasicMove implements Runnable
{
    private Basic_Line_Creator hilera;
    private Basic temp;
    private Gestor2 gestor;
    public BasicMove()
    {
        
    }
    public BasicMove(Basic_Line_Creator hilera,Gestor2 gest)
    {
        this.hilera=hilera;
        this.gestor=gest;
        
    }
    @Override
    public void run() 
    {
        while(true)
        {
            Basic temp=hilera.getHead();
            int ind=0;
            while(temp!=null)
            {
                Bullet b= gestor.getDatos().getSet().getBull();
                if(b.getBullx()<temp.getX()+64&& b.getBullx()+24>temp.getX()
                   && b.getBully()<temp.getY()+64&&b.getBully()+24> temp.getY())
                {
                    System.out.println("Killing");
                    hilera.eliminate(ind);
                    break;
                }
                temp=temp.getNext();
                ++ind;
            }
            
            if(hilera.getHead().getX()<=hilera.getHead().getInf())
            {
                temp=hilera.getHead();
                while(temp!=null)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                }
                
            }
            else if(hilera.getHead().getX()>=hilera.getHead().getSup())
            {
                temp=hilera.getHead();
                while(temp!=null)
                {
                    temp.chnDir();
                    temp.chnX();
                    temp.chnY();
                    temp=temp.getNext();
                    
                }
            }
            else
            {
                temp=hilera.getHead();
                while(temp!=null)
                {
                    temp.chnX();
                    temp=temp.getNext();
                }
                
                    
            }
        try {
            Thread.sleep(300);
            } 
        catch (InterruptedException ex) 
            {
            }
            
        }
      }
}

