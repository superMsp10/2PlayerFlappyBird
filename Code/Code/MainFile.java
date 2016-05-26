package Code;



import javax.swing.JOptionPane;
import javax.swing.JFrame;

import Level.DefaultLevel;
import Player.*;
import graphics.*;
import inputs.*;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.Graphics;

public class MainFile extends Canvas implements Runnable {
 private static final long serialVersionUID = 1L;

 public static int WIDTH = 400;
 public static int HEIGHT = 300;
 public static int SCALE = 2;

 public boolean running = false;

 JFrame frame;
 private Thread thread;
 private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
                                                 BufferedImage.TYPE_INT_RGB);
 private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
   .getData();
 
 public static Display SCREEN;
 public DefaultLevel lev = new DefaultLevel();
 public Player p;
 public static int GRAVITY = 10;
 private Keyboard keyboard;
 private Mouse mouse;

 public static void main(String[] args) {

  String controls = "-------Player 1-----------//CONTROLS//-------Player 2-----------------\n"
    + "JUMP:---Space------------------||------------Up Arrow------------------\n";

  JOptionPane
    .showMessageDialog(
      null,
      "Welcome to 2 Player Flappy Bird \nMade by Mahan Pandey \n Press OK to continue\n"
        + controls);

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
  keyboard = Keyboard.defKeyboard;
  addKeyListener(keyboard);
  mouse = new Mouse();
  p = new Player(keyboard);

 }

 public void run() {
  
  long timer = System.currentTimeMillis();
  long lastTime = System.nanoTime();
  int updates = 0;

  final double wantedUpdates = 1000000000.0 / 30.0;
  double delta = 0;
  while (running) {

   render();
   long now = System.nanoTime();
   delta += (now - lastTime) / wantedUpdates;
   lastTime = now;

   while (delta >= 1) {
    update();
    updates++;
    delta--;
   }

   if (System.currentTimeMillis() - timer > 1000) {
    timer += 1000;
//    System.out.println(updates);
    updates = 0;
   }
  }

 }

 public void update() {
  lev.Update();
  p.Update();
  keyboard.update();

 }

 public void render() {
  BufferStrategy bs = getBufferStrategy();
  if (bs == null) {
   createBufferStrategy(3);
   return;
  }

  SCREEN.clear();
  lev.Render(SCREEN);
  p.Render(SCREEN);
  
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
