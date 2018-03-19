/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;
import Ventanas.Gestor;
import Ventanas.V_Estadistica;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Camacho
 */
public class Juego
{
private Font FuenteMarc;
private JFrame Ventana= new JFrame();
private  static int Navx=460;
private  static int Navy=605;
private  Canv canv= new Canv();
private int marc;
private String marcs=String.format("%013d",marc);
private final Image Shoot=Toolkit.getDefaultToolkit().getImage("Resources/disparos/Shoot.png");
private JLabel Punt= new JLabel(marcs);
public Juego()
{
    try
    {
        FuenteMarc= Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Marcador.ttf"));
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    Ventana.setTitle(Gestor.getTitle());
    Ventana.setSize(1300,700);
    Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Ventana.setUndecorated(true);
    Ventana.setLocationRelativeTo(null);
    Ventana.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.BLACK));
    Ventana.setResizable(false);
    Ventana.setIconImage(Gestor.getIcon());
    Ventana.setFocusable(true);
    Ventana.addKeyListener(new Teclado());
    
    
    
    JPanel fondo=new JPanel();
    fondo.setBackground(Color.DARK_GRAY);
    fondo.setPreferredSize(new Dimension(985,670));
    fondo.add(canv);
    Ventana.getContentPane().add(fondo,BorderLayout.EAST);
    
    JPanel Panel1= new JPanel();
    Panel1.setPreferredSize(new Dimension(300,1000));
    Panel1.setBackground(Color.DARK_GRAY);
    Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,8,Color.BLACK));
    Ventana.add(Panel1,BorderLayout.WEST);
    
    Punt.setBackground(Gestor.getColor());
    Punt.setOpaque(true);
    Punt.setBorder(BorderFactory.createMatteBorder(4,0,8,0, Color.BLACK));
    Punt.setBounds(0,0,292,75);
    Punt.setForeground(Color.GREEN);
    Punt.setFont(FuenteMarc.deriveFont(Font.PLAIN,20));
    Panel1.setLayout(null);
    Panel1.add(Punt);
    
    JLabel Punt2= new JLabel();
    Punt2.setBackground(Color.BLACK);
    Punt2.setOpaque(true);
    Punt2.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.DARK_GRAY));
    Punt2.setBounds(0,75,292,250);
    Punt2.setForeground(Color.GREEN);
    Panel1.add(Punt2);
    
    JLabel Punt3= new JLabel();
    Punt3.setBackground(Color.BLACK);
    Punt3.setOpaque(true);
    Punt3.setBounds(0,325,292,8);
    Panel1.add(Punt3);
    
    JLabel Punt4= new JLabel("CURRENT ");
    Punt4.setBounds(5,210,292,292);
    Punt4.setForeground(Color.GREEN);
    Punt4.setFont(FuenteMarc.deriveFont(Font.PLAIN,15));
    Panel1.add(Punt4);
    
    JLabel Punt5= new JLabel("NEXT ");
    Punt5.setBounds(5,280,292,292);
    Punt5.setForeground(Color.GREEN);
    Punt5.setFont(FuenteMarc.deriveFont(Font.PLAIN,15));
    Panel1.add(Punt5);
    
    JButton Abort= new JButton("Abort");
    Abort.setForeground(Color.GREEN);
    Abort.setBackground(Gestor.getColor());
    Abort.setFont(Gestor.getFont().deriveFont(Font.PLAIN,20));
    Abort.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
    Abort.setFocusPainted(false);
    Abort.setBounds(48,550, 200, 70);
    Abort.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
        
        
    });
    Panel1.add(Abort);
    
    JLabel Punt7= new JLabel("LEVEL ");
    Punt7.setBounds(5,350,292,292);
    Punt7.setForeground(Color.GREEN);
    Punt7.setFont(FuenteMarc.deriveFont(Font.PLAIN,15));
    Panel1.add(Punt7);
    
    JLabel Punt6= new JLabel();
    Punt6.setIcon(new ImageIcon(V_Estadistica.getBack2()));
    Punt6.setBounds(0,320,292,500);
    Panel1.add(Punt6); 
  }

   public JFrame getFrame()
   {
       return Ventana;
   }
   public static int getX()
   {
   return Navx;
   }
   public static int getY()
   {
       return Navy;
   }
   public  Canv getCanv()
   {
       return canv;
   }
public class Teclado implements KeyListener
{
        @Override
        public void keyTyped(KeyEvent e) 
        {
            
        }
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int code= e.getKeyCode();
            if(code==KeyEvent.VK_RIGHT)
            {
                if (Navx+20>=920)
                  {
                      Navx=920;
                      canv.repaint();

                  }
                else
                  {    
                    Navx+=25;
                    canv.repaint();
                  }
            }
            else if(code==KeyEvent.VK_LEFT)
            {
                if (Navx-20<=0)
                   {
                       Navx=0;
                       canv.repaint();
                   }
                else 
                   {    
                     Navx-=25;
                     canv.repaint();
                   }
            }
            if(code==KeyEvent.VK_F)
                if(canv.getBullet().getCond()==0)
                    {
                     canv.setCond();
                     canv.getBullet().setY(Juego.getY());
                     canv.getBullet().setX();
                     Shoot t=new Shoot();
                     t.start();
                    }
                
           
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
            
        }
public class Shoot extends Thread
        {
            public void run()
            {
                while(canv.getBullet().getBullY()>=0)
                {
                    canv.getBullet().setY(-20);
                    canv.setCond();
                    canv.repaint();
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                
                }
                addMarc(100);
                Punt.setText(marcs);
                updateMarcs();
                canv.setCond();
                canv.repaint();
            }
        }
    public void addMarc(int x)
    {
        marc+=x;
    }
    public void updateMarcs()
    {
     marcs=String.format("%013d",marc); 
    }
}
}

