
package Ventanas;
import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author Daniel Camacho
 */
public class V_Datos extends Gestor
{
  private final Image Back=Toolkit.getDefaultToolkit().getImage("Resources/Back.png");
  public V_Datos()
  {
   JFrame Ventana= new JFrame(Titulo);
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
   Panel1.setLayout(new OverlayLayout(Panel1));
   
   JLabel Back1= new JLabel(new ImageIcon(Back));
   Back1.setBorder(BorderFactory.createMatteBorder(4,0,0,0,Color.BLACK));
   Back1.setFont(FuenteTitulo.deriveFont(Font.PLAIN,20));
   Back1.setText("Hola");
   Back1.setHorizontalTextPosition(JLabel.CENTER);
   Panel1.add(Back1);
   
   Ventana.add(Panel1,BorderLayout.SOUTH);
   Ventana.setVisible(true);
   
  }
}
