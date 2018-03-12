/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

/**
 *
 * @author dcama
 */
public class Gestor
{
   protected final String Titulo="Invaders";
   protected final Image Icono=Toolkit.getDefaultToolkit().getImage("Resources/Icono.png");
   protected Font FuenteTitulo;
   protected final Color Btn=new Color(75,0,130);
    public Gestor()
    {
        try 
        {
        FuenteTitulo = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Furore.ttf"));
        
        } 
        catch(Exception e) 
        {
            FuenteTitulo = null;
        }
        
         
    }


    /**
     * Metodo encargado de determinar cual ventana se despliega
     * @param x Numero de ventana a desplegar
     */
    public void GestWindow(int x)
    {
        switch(x)
        {
            case(1):
            {
             V_Inicial Ventana=new V_Inicial();
            }
        }
    }
}
