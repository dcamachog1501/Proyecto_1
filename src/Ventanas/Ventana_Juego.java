/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Componentes_Jugador.Bullet;
import Enemigos.Basic_Line_Creator;
import Threads.BasicMove;
import Threads.Left;
import Threads.Right;
import Threads.Setup;
import Threads.Shoot;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 *Clase encargada del de desarrollo de ventanas de juego.
 * @author Daniel Camacho
 */
public class Ventana_Juego extends JFrame
{
    //Canvas en el que se desarrolla el juego 
    private  Canvas canv;
    
    
    //Marcador del juego 
    private int marc;
    
    
    // Datos escritos que se proyectan en el marcador
    private String marcs=String.format("%013d",marc);
    
    
    //Label que proyecta el marcador 
    private JLabel Punt= new JLabel(marcs);
   
    //KeyListeners encargados de recibir los inputs del usuario
    private Teclado0 tec0= new Teclado0();
    private Teclado2 tec2= new Teclado2();
    
    //Atributos de la ventana
    private String title;
    private Font fuentet;
    private Image back;
    private Image icono;
    private Color color;
    private Font fuentem;
    private Gestor2 gest;
    private Setup set;
    
    //Thread que permite el movimiento continuo de los enemigos.
    private Thread mover;
    private BasicMove move;
    
    private Basic_Line_Creator basic;
    
    Ventana_Juego(String title,Font FuenteT,Image back,Image Icono, Color Btn,Font FuenteM,Gestor2 gest,Setup set)
    {
       this.title=title;
       this.fuentem=FuenteM;
       this.fuentet=FuenteT;
       this.back=back;
       this.icono=Icono;
       this.color=Btn;
       this.gest=gest;
       this.set=set;
       basic=new Basic_Line_Creator();
       basic.createLine();
       this.move= new BasicMove(basic,gest);
       Init();
    }
  public Basic_Line_Creator getBasic()
   {
       return basic;
   }
  public Teclado2 getTec()
  {
      return tec2;
  }
  /**
   * Metodo para agregar puntos al marcador 
   * @param x cantidad entera de puntos a agregar 
   */
  public void addMarc(int x)
  {
      marc+=x;
  }
  /**
   * Metodo para actualizar el marcador.
   */
  public void updateMarcs()
    {
        Punt.setText(marcs);
    }
  /**
   * Metodo para obtener el canvas de la ventana
   * @return objeto de tipo canvas 
   */
  public Canvas getCanvas()
    {
        return canv;
    }
  
  public void rem()
  {
      this.removeKeyListener(tec2);
  }
  public void adder()
  {
      this.addKeyListener(tec2);
  }
  public void moveStarter()
  {
      mover= new Thread(move);
      mover.start();
  }
  public Thread getMover()
  {
      return mover;
  }
  /**
   * Metodo que inicializa la ventana
   */
  public void Init()
  {
        canv=new Canvas();
        canv.setPreferredSize(new Dimension(985,720));
        canv.setBackground(Color.DARK_GRAY);
        setTitle(title);
        setSize(1300,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.BLACK));
        setResizable(false);
        setIconImage(icono);
        setFocusable(true);
        addKeyListener(tec0);
        addKeyListener(tec2);

        JPanel fondo=new JPanel();
        fondo.setBackground(Color.DARK_GRAY);
        fondo.setPreferredSize(new Dimension(985,670));
        fondo.add(canv);
        getContentPane().add(canv,BorderLayout.EAST);

        JPanel Panel1= new JPanel();
        Panel1.setPreferredSize(new Dimension(300,1000));
        Panel1.setBackground(Color.DARK_GRAY);
        Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,8,Color.BLACK));
        add(Panel1,BorderLayout.WEST);

        Punt.setBackground(color);
        Punt.setOpaque(true);
        Punt.setBorder(BorderFactory.createMatteBorder(4,0,8,0, Color.BLACK));
        Punt.setBounds(0,0,292,75);
        Punt.setForeground(Color.GREEN);
        Punt.setFont(fuentem.deriveFont(Font.PLAIN,20));
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
        Punt4.setFont(fuentem.deriveFont(Font.PLAIN,15));
        Panel1.add(Punt4);

        JLabel Punt5= new JLabel("NEXT ");
        Punt5.setBounds(5,280,292,292);
        Punt5.setForeground(Color.GREEN);
        Punt5.setFont(fuentem.deriveFont(Font.PLAIN,15));
        Panel1.add(Punt5);
        //Boton que permite salirse del juego
        JButton Abort= new JButton("Abort");
        Abort.setForeground(Color.GREEN);
        Abort.setBackground(color);
        Abort.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Abort.setFont(fuentet.deriveFont(Font.PLAIN,20));
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
        Punt7.setFont(fuentem.deriveFont(Font.PLAIN,15));
        Panel1.add(Punt7);

        JLabel Punt6= new JLabel();
        Punt6.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back2.png")));
        Punt6.setBounds(0,320,292,500);
        Panel1.add(Punt6);
        
  }
  //KeyListaner para mover la nave
  private class Teclado0 implements KeyListener
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
              Thread r= new Thread(new Right(gest));
              r.start();
              
            }
            else if(code==KeyEvent.VK_LEFT)
            {
              Thread l= new Thread(new Left(gest));
              l.run();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
       
        }
  }
 
  //KeyListener para disparar
  private class Teclado2 implements KeyListener
  {
        @Override
        public void keyTyped(KeyEvent e) 
        {
      
        }
        @Override
        public void keyPressed(KeyEvent e) 
        {
            int code= e.getKeyCode();
            if(code==KeyEvent.VK_F)
            {
              System.out.println("F");
              Shoot s= new Shoot(gest);
              s.run();
              
            }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
       
        }
      
  
  }
}
