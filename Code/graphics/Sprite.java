package graphics;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Sprite {

 public final int[] pixels;
 public int x, y;
 public final int Width;
 public final int Height;
 public final int Size;
 public int col;
 private String path;

 public static Sprite p1Wins = new Sprite("/P1Wins.png", 400);
 public static Sprite p2Wins = new Sprite("/P2Wins.png", 400);


 public Sprite(String path, int size) {
  Size = size;
  Width = size;
  Height = size;
  this.path = path;
  pixels = new int[size * size];
  load();
  System.out.println("pixel@ 0,0 : " + pixels[0] + path);


 }



 
 private void load() {
  try {
   BufferedImage image = ImageIO.read(Sprite.class.getResource(path));
   int w = image.getWidth();
   int h = image.getHeight();
   image.getRGB(0, 0, w, h, pixels, 0, w);
  } catch (IOException e) {
   e.printStackTrace();
  }

 }
 

}
