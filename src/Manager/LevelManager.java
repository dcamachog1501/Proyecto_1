/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Enemigos.Basic;
import Fabrica_Enemigos.Basic_Creator;
import Fabrica_Hileras.A_Line_Creator;
import Fabrica_Hileras.Basic_Line_Creator;
import Fabrica_Hileras.Line_Creator;
import Hileras.A_Line;
import Hileras.Hileras_GUI;
import Hileras.Line;
import Level_Creator.Level_Creator;
import Threads.BasicMove;
import Ventanas.Gestor2;

/**
 *
 * @author dcama
 */
public class LevelManager 
{
 int Level;
 Gestor2 gestor;
 Hileras_GUI gui;
 Line basic;
 BasicMove move;
 Level_Creator leveler;
 
 public LevelManager(Gestor2 gest)
 {
     this.Level=0;
     this.gestor=gest;
     this.gui= new Hileras_GUI();
     this.basic=gui.buildHilera(new Basic_Line_Creator(),gestor);
     basic.createLine();
     this.move= new BasicMove(basic,gestor);
     this.leveler= new Level_Creator(gestor);
 }
}
