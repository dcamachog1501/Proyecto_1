/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Juego.Bullet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author dcama
 */
public class Gestor2 
{
  private  final String Titulo="Invaders";
  private  final Image Icono=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/Icono.png");
  private  Font FuenteTitulo;
  private  Font FuenteMarc;
  private final  Color Btn=new Color(75,0,130);
  private final Color LightG=new Color(124,252,0);
  private JFrame VentanaInicial= new JFrame();
  private JFrame VentanaStatics= new JFrame();
  private  JFrame VentanaDatos= new JFrame();
  private  JFrame VentanaJuego= new JFrame();
  private final Image Back=Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Background.jpg");
  private Image Back2= Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back2.png");
  private Image PlayerNav;
  private String PlayerNam;
  private  int ind=0;
  private final Image Back1=Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back.png");
  private  final Image Nav1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave1.png");
  private  final Image Nav2=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave2.png");
  private  final Image Nav3=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave3.png");
  private  final Image Nav4=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave4.png");
  private  final Image Nav1_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave1_1.png");
  private  final Image Nav2_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave2_1.png");
  private  final Image Nav3_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave3_1.png");
  private  final Image Nav4_1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave4_1.png");
  private final Image Right=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/right.png");
  private final Image Left=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/left.png");
  private  Image navselector[]=new Image[]{Nav1,Nav2,Nav3,Nav4};
  private  Image navselector2[]=new Image[]{Nav1_1,Nav2_1,Nav3_1,Nav4_1};
  private  JLabel Nav=new JLabel(new ImageIcon(navselector[ind]));
  private JTextField Nombre= new JTextField(30);
  private JButton right=new JButton(new ImageIcon(Right));
  private JButton left=new JButton(new ImageIcon(Left));
  private JFrame Ventana= new JFrame();
  private  int Navx=460;
  private  int Navy=605;
  private  Canv canv= new Canv();
  private int marc;
  private String marcs=String.format("%013d",marc);
  private final Image Shoot=Toolkit.getDefaultToolkit().getImage("Resources/disparos/Shoot.png");
  private JLabel Punt= new JLabel(marcs);
  private final Bullet bala= new Bullet(Navx+17,Navy);
  private Update up;
  private Teclado0 tec0= new Teclado0();
  private Teclado2 tec2= new Teclado2();
  private Timer time;
  
    public Gestor2()
    {
        time = new Timer(5,new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                
            }
        });
       try
      {
          FuenteTitulo= Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Furore.ttf"));
      }
      catch(Exception e)
      {
          FuenteTitulo=null;
      }
        
      try
      {
        FuenteMarc= Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Fuentes/Marcador.ttf"));  
      }
      catch(Exception e)
      {
         FuenteMarc=null; 
      }
      up=new Update();
      up.start();
    }
    public void gestInicial()
    {
      VentanaInicial.setTitle(Titulo);
      VentanaInicial.setResizable(false);
      VentanaInicial.setUndecorated(true);
      VentanaInicial.setIconImage(Icono);
      VentanaInicial.setSize(600,700);
      VentanaInicial.setLocationRelativeTo(null);
      VentanaInicial.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,Color.BLACK));
      JLabel Uno= new JLabel(new ImageIcon(Back));
      Uno.setLayout(new BoxLayout(Uno,BoxLayout.Y_AXIS));
      
      JLabel Title= new JLabel("Invaders");
      Title.setFont(FuenteTitulo.deriveFont(Font.PLAIN,80));
      Title.setForeground(Color.GREEN);
      Title.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      Uno.add(Title);
     

      JLabel Icon=new JLabel();
      Icon.setIcon(new ImageIcon("Resources/Iconos/Icono2.png"));
      Icon.setHorizontalAlignment(JLabel.CENTER);
      Icon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
      Uno.add(Icon);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      JButton Jugar= new JButton("PLAY!");
      Jugar.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
      Jugar.setForeground(Btn);
      Jugar.setBackground(Color.GREEN);
      Jugar.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Jugar.setMaximumSize(new Dimension(300,100));
      Jugar.setFocusPainted(false);
      Jugar.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Jugar.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Jugar.addActionListener(new ActionListener()
        {
       @Override
       public void actionPerformed(ActionEvent e) 
       {
        VentanaInicial.dispose();
        gestDatos();
       }
        });
      Uno.add(Jugar);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      JButton Estadísticas= new JButton("Records");
      Estadísticas.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
      Estadísticas.setForeground(Btn);
      Estadísticas.setBackground(Color.GREEN);
      Estadísticas.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Estadísticas.setMaximumSize(new Dimension(300,100));
      Estadísticas.setFocusPainted(false);
      Estadísticas.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Estadísticas.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Estadísticas.addActionListener(new ActionListener()
   {
       @Override
       public void actionPerformed(ActionEvent e) 
       {
        VentanaInicial.dispose();
        gestStatics();
       }
   });
      Uno.add(Estadísticas);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      JButton Salir= new JButton("Quit");
      Salir.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
      Salir.setForeground(Btn);
      Salir.setBackground(Color.GREEN);
      Salir.setAlignmentX(JButton.CENTER_ALIGNMENT);
      Salir.setMaximumSize(new Dimension(300,100));
      Salir.setFocusPainted(false);
      Salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Salir.addActionListener(new ActionListener()
   {
       @Override
       public void actionPerformed(ActionEvent e) 
       {
        System.exit(0);
       }
   });
      Salir.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
      Uno.add(Salir);
      Uno.add(Box.createRigidArea(new Dimension(100,50)));
      
      VentanaInicial.add(Uno,BorderLayout.CENTER);
      VentanaInicial.setVisible(true);
    }
    public void gestStatics()
    {
    VentanaStatics.setTitle(Titulo);
    VentanaStatics.setSize(1050,700);
    VentanaStatics.setResizable(false);
    VentanaStatics.setUndecorated(true);
    VentanaStatics.setIconImage(Icono);
    VentanaStatics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    VentanaStatics.setLocationRelativeTo(null);
    VentanaStatics.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,Color.BLACK));
    
    JPanel Panel1= new JPanel();
    Panel1.setBackground(Color.DARK_GRAY);
    Panel1.setPreferredSize(new Dimension(200,1000));
    Panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4,Color.BLACK));
    Panel1.setLayout(null);
    VentanaStatics.add(Panel1,BorderLayout.WEST);
    
    JPanel Panel2= new JPanel();
    Panel2.setBackground(Color.DARK_GRAY);
    Panel2.setPreferredSize(new Dimension(225,1000));
    Panel2.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0,Color.BLACK));
    Panel2.setLayout(null);
    VentanaStatics.add(Panel2,BorderLayout.EAST);
    
    JPanel Panel3= new JPanel();
    Panel3.setBackground(Color.DARK_GRAY);
    Panel3.setPreferredSize(new Dimension(200,2000));
    Panel3.setLayout(null);
    VentanaStatics.add(Panel3,BorderLayout.CENTER);
    
    JLabel Label1= new JLabel();
    Label1.setOpaque(true);
    Label1.setBackground(Btn);
    Label1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4,Color.BLACK));
    Label1.setBounds(0,0,25,700);
    Panel3.add(Label1);
    
    JLabel Label2= new JLabel();
    Label2.setOpaque(true);
    Label2.setBackground(Btn);
    Label2.setBorder(BorderFactory.createMatteBorder(0, 4, 0, 0,Color.BLACK));
    Label2.setBounds(593,0,25,700);
    Panel3.add(Label2);
    
    JLabel Label3= new JLabel("GALAXY'S BEST PILOTS");
    Label3.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
    Label3.setForeground(Color.GREEN);
    Label3.setBounds(60,0,1000,100);
    Panel3.add(Label3);
    
     JLabel Label4= new JLabel("1.     --");
    Label4.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
    Label4.setForeground(Color.GREEN);
    Label4.setBounds(40,100,1000,100);
    Panel3.add(Label4);
    
     JLabel Label5= new JLabel("2.     --");
    Label5.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
    Label5.setForeground(Color.GREEN);
    Label5.setBounds(40,200,1000,100);
    Panel3.add(Label5);
    
     JLabel Label6= new JLabel("3.     --");
    Label6.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
    Label6.setForeground(Color.GREEN);
    Label6.setBounds(40,300,1000,100);
    Panel3.add(Label6);
    
     JLabel Label7= new JLabel("4.     --");
    Label7.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
    Label7.setForeground(Color.GREEN);
    Label7.setBounds(40,400,1000,100);
    Panel3.add(Label7);
    
     JLabel Label8= new JLabel("5.     --");
    Label8.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
    Label8.setForeground(Color.GREEN);
    Label8.setBounds(40,500,1000,100);
    Panel3.add(Label8);
    
    JButton Menu= new JButton("MAIN MENU");
    Menu.setForeground(Color.GREEN);
    Menu.setBackground(Btn);
    Menu.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
    Menu.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
    Menu.setFocusPainted(false);
    Menu.setBounds(20,550, 200, 70);
    Menu.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            VentanaStatics.dispose();
            gestInicial();
        }
        
    });
    Panel1.add(Menu);
    
    JButton Abort = new JButton("ABORT");
    Abort.setForeground(Color.GREEN);
    Abort.setBackground(Btn);
    Abort.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
    Abort.setBorder(BorderFactory.createMatteBorder(4,0,4,4,Color.BLACK));
    Abort.setFocusPainted(false);
    Abort.setBounds(0,75, 200, 70);
    Abort.addActionListener(new ActionListener()
    {
        

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }
    );
    Panel2.add(Abort);
    
    JLabel Back3=new JLabel();
    Back3.setIcon(new ImageIcon(Back2));
    Back3.setBounds(0,0,200,700);
    Back3.setBorder(BorderFactory.createMatteBorder(0,0,0,4,Color.BLACK));
    Panel1.add(Back3);
    
    JLabel Back4=new JLabel();
    Back4.setIcon(new ImageIcon(Back2));
    Back4.setBounds(0,0,250,700);
    Back4.setBorder(BorderFactory.createMatteBorder(0,4,0,0,Color.BLACK));
    Panel2.add(Back4);
    VentanaStatics.setVisible(true);
    }
    public void gestDatos()
    {
        VentanaDatos.setTitle(Titulo);
        VentanaDatos.setSize(1000,700);
        VentanaDatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaDatos.setUndecorated(true);
        VentanaDatos.setLocationRelativeTo(null);
        VentanaDatos.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        VentanaDatos.setResizable(false);
        VentanaDatos.setIconImage(Icono);
        VentanaDatos.addKeyListener(new Teclado());
        VentanaDatos.setFocusable(true);

        JPanel Panel1= new JPanel();
        Panel1.setBackground(Color.DARK_GRAY);
        Panel1.setPreferredSize(new Dimension(300,200));
        Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.BLACK));
        Panel1.setLayout(null);
        VentanaDatos.add(Panel1,BorderLayout.SOUTH);

        JPanel Panel2=new JPanel();
        Panel2.setBackground(Color.DARK_GRAY);
        Panel2.setPreferredSize(new Dimension(300,493));
        Panel2.setLayout(null);
        VentanaDatos.add(Panel2,BorderLayout.NORTH);

        Nav.setBounds(410,180,128,128);
        Panel2.add(Nav);

        Nombre.setBounds(160,50,200,30);
        Nombre.setFont(FuenteTitulo.deriveFont(Font.PLAIN,15));
        Nombre.setForeground(Color.BLACK);
        Nombre.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.GRAY));
        Panel1.add(Nombre);

        JLabel Nickname=new JLabel("Pilot Name:");
        Nickname.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 20));
        Nickname.setForeground(Color.GREEN);
        Nickname.setBounds(20, 50, 300, 30);
        Panel1.add(Nickname);

        JButton Abort= new JButton("Abort");
        Abort.setForeground(Color.GREEN);
        Abort.setBackground(Btn);
        Abort.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
        Abort.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        Abort.setFocusPainted(false);
        Abort.setBounds(20,120, 200, 70);
        Abort.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
             System.exit(0);
            }
        });
        Panel1.add(Abort);

        JButton Play= new JButton("PLAY!");
        Play.setForeground(Color.GREEN);
        Play.setBackground(Btn);
        Play.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
        Play.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        Play.setFocusPainted(false);
        Play.setBounds(700,30, 250, 140);
        Play.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 setNav();
                 setName();
                 VentanaDatos.dispose();
                 gestJuego();

            }
        });
        Panel1.add(Play);

        JButton back= new JButton("MAIN MENU");
        back.setForeground(Btn);
        back.setBackground(Color.GREEN);
        back.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
        back.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
        back.setFocusPainted(false);
        back.setBounds(375,120, 200, 70);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                 VentanaDatos.dispose();
                 gestJuego();
            }

        });
        Panel1.add(back);

        JLabel Back=new JLabel(new ImageIcon(Back1));
        Back.setBounds(0,0,1000, 200);
        Back.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.BLACK));
        Panel1.add(Back);

        right.setOpaque(false);
        right.setContentAreaFilled(false);
        right.setBorderPainted(false);
        right.setBounds(570,220, 64, 64);
        right.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                changeShip(1);
                 changeLbl();
            }

        });
        Panel2.add(right);

        left.setOpaque(false);
        left.setContentAreaFilled(false);
        left.setBorderPainted(false);
        left.setBounds(315,220,64,64);
        left.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
              changeShip(0);
              changeLbl();  
            }

        });
        Panel2.add(left);

        JLabel Titulo2=new JLabel("SELECT A SPACESHIP");
        Titulo2.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
        Titulo2.setForeground(Color.GREEN);
        Titulo2.setBounds(240, 20, 500, 100);
        Panel2.add(Titulo2);
        VentanaDatos.setVisible(true);
       }
    public void gestJuego()
    {
        VentanaJuego.setTitle(Titulo);
        VentanaJuego.setSize(1300,700);
        VentanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        VentanaJuego.setUndecorated(true);
        VentanaJuego.setLocationRelativeTo(null);
        VentanaJuego.getRootPane().setBorder(BorderFactory.createMatteBorder(8,8,8,8, Color.BLACK));
        VentanaJuego.setResizable(false);
        VentanaJuego.setIconImage(Icono);
        VentanaJuego.setFocusable(true);
        VentanaJuego.addKeyListener(tec2);
        VentanaJuego.addKeyListener(tec0);

        JPanel fondo=new JPanel();
        fondo.setBackground(Color.DARK_GRAY);
        fondo.setPreferredSize(new Dimension(985,670));
        fondo.add(canv);
        VentanaJuego.getContentPane().add(fondo,BorderLayout.EAST);

        JPanel Panel1= new JPanel();
        Panel1.setPreferredSize(new Dimension(300,1000));
        Panel1.setBackground(Color.DARK_GRAY);
        Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,8,Color.BLACK));
        VentanaJuego.add(Panel1,BorderLayout.WEST);

        Punt.setBackground(Btn);
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
        Abort.setBackground(Btn);
        Abort.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
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
        Punt6.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back2.png")));
        Punt6.setBounds(0,320,292,500);
        Panel1.add(Punt6);
        VentanaJuego.setVisible(true);
    }
           
    
    public  void changeShip(int num)
 {
  if(num==1)
  {
      if(ind==3)
      {
          ind=0;
      }
      else
      {
          ind+=1;
      }
  }
  else if(num==0)
  {
      if(ind==0)
      {
          ind=3;
      }
      else
      {
          ind-=1;
      }
  }
 }
 
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
              Right r= new Right();
              r.start();
              
            }
            else if(code==KeyEvent.VK_LEFT)
            {
              Left l= new Left();
              l.start();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
       
        }
  }
  private class Teclado implements KeyListener
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
               right.doClick();
            }
            else if(code==KeyEvent.VK_LEFT)
            {
                left.doClick(); 
            }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
       
        }
  }
  
  private class Teclado2 implements KeyListener
  {
        @Override
        public void keyTyped(KeyEvent e) 
        {
      
        }
        @Override
        public void keyPressed(KeyEvent e) 
        {
            System.out.println("Presionado");
            int code= e.getKeyCode();
            if(code==KeyEvent.VK_F)
            {
                System.out.println("F");
                Shoot t= new Shoot();
                VentanaJuego.removeKeyListener(tec2);
                t.start();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) 
        {
       
        }
      
  
  }
  
  public void setNav()
  {
      PlayerNav=navselector2[ind];
  }
  public void setName()
  {
      PlayerNam=Nombre.getText();
  }
  public Image getNav()
  {
      return PlayerNav;
  }
  public  void changeLbl()
  {
     Nav.setIcon(new ImageIcon(navselector[ind]));
  }
  public int getNavx()
  {
      return Navx;
  }
  public int getNavy()
  {
      return Navy;
  }
  public void setY()
  {
      
  }
  public Bullet getBull()
  {
      return bala;
  }
  public void addMarc(int x)
  {
      marc+=x;
  }
  public void updateMarcs()
  {
      Punt.setText(marcs);
  }
public class Canv extends JComponent

{
 private int cond=1;   
    public Canv()
      {
          setPreferredSize(new Dimension(985,670)); 
          
   
      }
    
      @Override
      public void paint(Graphics g)
      {
          g.drawImage(PlayerNav,Navx,Navy,this);
          if (bala.getCond()==1)
          {
          g.drawImage(bala.getImage(),bala.getBullX()+17,bala.getBullY(),this);
          }
      }
}


public class Shoot extends Thread
{
    @Override
    public void run()
    {
        bala.setCond();
        while(bala.getBullY()>0)
        {
            System.out.println(bala.getBullY());
            System.out.println("Thread");
            bala.setY(25);
            System.out.println(bala.getBullY());
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        bala.setBully(Navy);
        bala.setBullx(Navx);
        addMarc(100);
        bala.setCond();
        VentanaJuego.addKeyListener(tec2);
    }
}
public class Update extends Thread
{
    @Override
    public void run()
    {
        while(true)
        {
            canv.repaint();
            updateMarcs();
        }
          
    }
}
public class Right extends Thread
{
    @Override
    public void run()
    {
        if(Navx<920)
              {
               Navx+=20;
              }
              else
              {
              Navx=920;
              }
    }
}
public class Left extends Thread
{
    @Override
    public void run()
    {
        if(Navx>0)
              {
                Navx-=20;
              }
              else
              {
              Navx=0;
              }
    }
}
}

    
