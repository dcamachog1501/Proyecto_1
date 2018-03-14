/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;
import Ventanas.Gestor;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Daniel Camacho
 */
public class Canvas extends JFrame
{
    public Canvas()
    {
    setTitle(Gestor.getTitle());
    this.setSize(1000,700);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setUndecorated(true);
    setLocationRelativeTo(null);
    getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
    setResizable(false);
    setIconImage(Gestor.getIcon());
    setFocusable(true); 
    setVisible(true);
    }
}
