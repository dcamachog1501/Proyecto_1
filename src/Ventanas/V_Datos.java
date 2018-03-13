
package Ventanas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Daniel Camacho
 */
public class V_Datos extends Gestor
{
  private static int ind=0;
  private final Image Back1=Toolkit.getDefaultToolkit().getImage("Resources/Backgrounds/Back.png");
  private static final Image Nav1=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave1.png");
  private static final Image Nav2=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave2.png");
  private static final Image Nav3=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave3.png");
  private static final Image Nav4=Toolkit.getDefaultToolkit().getImage("Resources/Naves/Nave4.png");
  private final Image Right=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/right.png");
  private final Image Left=Toolkit.getDefaultToolkit().getImage("Resources/Iconos/left.png");
  private static Image lista[]=new Image[]{Nav1,Nav2,Nav3,Nav4};
  private static JLabel Nav=new JLabel(new ImageIcon(lista[ind]));
  private static JFrame Ventana= new JFrame();
  public V_Datos()
  {
   Ventana.setTitle(Titulo);
   Ventana.setSize(1000,700);
   Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   Ventana.setUndecorated(true);
   Ventana.setLocationRelativeTo(null);
   Ventana.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
   Ventana.setResizable(false);
   Ventana.setIconImage(Icono);
   
   JPanel Panel1= new JPanel();
   Panel1.setBackground(Color.DARK_GRAY);
   Panel1.setPreferredSize(new Dimension(300,200));
   Panel1.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.BLACK));
   Panel1.setLayout(null);
   Ventana.add(Panel1,BorderLayout.SOUTH);
   
   JPanel Panel2=new JPanel();
   Panel2.setBackground(Color.DARK_GRAY);
   Panel2.setPreferredSize(new Dimension(300,493));
   Panel2.setLayout(null);
   Ventana.add(Panel2,BorderLayout.NORTH);
   
   Nav.setBounds(410,180,128,128);
   Panel2.add(Nav);
   
   JTextField Nombre= new JTextField(30);
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
   Abort.addActionListener(new Exit());
   Panel1.add(Abort);
   
   JButton Play= new JButton("PLAY!");
   Play.setForeground(Color.GREEN);
   Play.setBackground(Btn);
   Play.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
   Play.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
   Play.setFocusPainted(false);
   Play.setBounds(700,30, 250, 140);
   Panel1.add(Play);
   
   JButton back= new JButton("MAIN MENU");
   back.setForeground(Btn);
   back.setBackground(Color.GREEN);
   back.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
   back.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.BLACK));
   back.setFocusPainted(false);
   back.setBounds(375,120, 200, 70);
   back.addActionListener(new Back());
   Panel1.add(back);
   
   JLabel Back=new JLabel(new ImageIcon(Back1));
   Back.setBounds(0,0,1000, 200);
   Back.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.BLACK));
   Panel1.add(Back);
   
   JButton right=new JButton(new ImageIcon(Right));
   right.setOpaque(false);
   right.setContentAreaFilled(false);
   right.setBorderPainted(false);
   right.setBounds(570,220, 64, 64);
   right.addActionListener(new Right());
   Panel2.add(right);
   
   JButton left=new JButton(new ImageIcon(Left));
   left.setOpaque(false);
   left.setContentAreaFilled(false);
   left.setBorderPainted(false);
   left.setBounds(315,220,64,64);
   left.addActionListener(new Left());
   Panel2.add(left);
   
   JLabel Titulo2=new JLabel("SELECT A SPACESHIP");
   Titulo2.setFont(FuenteTitulo.deriveFont(Font.PLAIN, 40));
   Titulo2.setForeground(Color.GREEN);
   Titulo2.setBounds(240, 20, 500, 100);
   Panel2.add(Titulo2);
   
   Ventana.setVisible(true);
  
   
  }
 public static void changeShip(int num)
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
 public static void changeLbl()
 {
     Nav.setIcon(new ImageIcon(lista[ind]));
 }
 static class Right implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            V_Datos.changeShip(1);
            V_Datos.changeLbl();
        }

    }
 static class Back implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Ventana.dispose();
            GestWindow(1);
        }

    }
 static class Left implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            V_Datos.changeShip(0);
            V_Datos.changeLbl();
        }

    }
 static class Exit implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }

    }
}
