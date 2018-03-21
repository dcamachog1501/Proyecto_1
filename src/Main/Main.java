/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Juego.Setup;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public class Main {
    
    
    public static void main(String[] args) 
    {
       Gestor2 g =Setup.getGest();
       g.gestInicial();
    }

}
