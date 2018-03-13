/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import java.awt.*;
import java.io.*;

/**
 *
 * @author dcama
 */
public class Gestor
{
   protected final String Titulo="Invaders";
   protected final Image Icono=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/Icono.png");
   protected Font FuenteTitulo;
   protected final Color Btn=new Color(75,0,130);
   protected final Color LightG=new Color(124,252,0);
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
    public static void GestWindow(int x)
    {
        switch(x)
        {
            case(1):
            {
             V_Inicial Ventana=new V_Inicial();
             break;
            }
            case(2):
            {
                V_Datos Ventana=new V_Datos();
                break;
            }
        }
    }

    void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
