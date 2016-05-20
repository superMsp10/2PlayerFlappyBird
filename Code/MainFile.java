package Code;
import graphics.*;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Graphics;



public class MainFile extends Canvas implements Runnable {
  private static final long serialVersionUID = 1L;
  
  public static int WIDTH = 200;
  public static int HEIGHT = 100;
  public static int SCALE = 4;
  
  public boolean running = false;
  
  JFrame frame;
  private Thread thread;
  
  public static Display SCREEN;
  private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
  private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
  
  public static void main(String[] args) { 

    String controls = "-------Player 1-----------//CONTROLS//-------Player 2-----------------\n"+
      "JUMP:---Space-----------------||-------Up Arrow--------\n";
    
    JOptionPane.showMessageDialog(null,"Welcome to 2 Player Flappy Bird \nMade by Mahan Pandey \n Press OK to continue\n" + controls);

     MainFile main = new MainFile();
      main.frame.setResizable(false);
      main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      main.frame.add(main);
      main.frame.pack();
      main.frame.setLocationRelativeTo(null);
      main.frame.setVisible(true);
      main.frame.setTitle("2PlayerFlappyBird");
      main.start();
     
  
  }
  
  public MainFile() {
    Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
    setPreferredSize(size);
    frame = new JFrame();
    SCREEN = new Display();

    
  }
  
   public void run() {

     
     while(running){
        render();
     }

   }
   
    public void render() {
      BufferStrategy bs = getBufferStrategy();
      if (bs == null) {
        createBufferStrategy(3);
        return;
      }
      
      SCREEN.clear();
      
      for (int i = 0; i < pixels.length; i++) {
        pixels[i] = SCREEN.pixels[i];
      }
      Graphics g = bs.getDrawGraphics();
      g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
      g.dispose();
      bs.show();
    }
    
   private void start() {
     running = true;
     thread = new Thread(this, "Display");
     thread.start();

     
   }
   
   public synchronized void stop() {
     
     running = false;
     try {
       thread.join();
     } catch (InterruptedException e) {
       e.printStackTrace();
     }
     
   }

  
 
  
}
