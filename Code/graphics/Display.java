package graphics;
import java.util.Random;


import Code.MainFile;



public class Display {
 public int[] pixels;
 public Random random;
 public int xOffSet;
 public int yOffSet;

 public Display() {
  pixels = new int[MainFile.WIDTH * MainFile.HEIGHT];
  random = new Random();
 }

 public void clear() {
  for (int i = 0; i < pixels.length; i++) {
   pixels[i] = 100000;
  }

 }

 public void testRender() {

  for (int y = 0; y < MainFile.HEIGHT; y++) {
   for (int x = 0; x < MainFile.WIDTH; x++) {
    pixels[x + y * MainFile.WIDTH] = random.nextInt();
   }

  }

 }

 public void renderSprite(Sprite sprite, int xstart, int ystart) {

  for (int y = 0; y < sprite.Height; y++) {
   int yy = ystart + y;
   if (yy >= MainFile.HEIGHT || yy < 0) continue;

   for (int x = 0; x < sprite.Width; x++) {
    int xx = xstart + x;
    if (xx >= MainFile.WIDTH || xx < 0) continue;
    
    int col = sprite.pixels[x + y * sprite.Size];
    if(col != -16777216)
    pixels[xx + yy * MainFile.WIDTH] = col;

   }

  }
 }
 
 
 public void renderPlayer(Sprite sprite, int xstart, int ystart, boolean flip , boolean tint) {
   
   for (int y = 0; y < sprite.Height; y++) {
     int yy = ystart + y;
     if (yy >= MainFile.HEIGHT || yy < 0) continue;
     
     if(flip){
       for (int x = 0; x < sprite.Width; x++) {
         int xx = xstart + x;
         if (xx >= MainFile.WIDTH || xx < 0) continue;
         
         
         int col = sprite.pixels[(sprite.Width - (x + 1)) + y * sprite.Size];
         if(col != -16777216){
           if(tint)
           pixels[xx + yy * MainFile.WIDTH] = col;
           else
           pixels[xx + yy * MainFile.WIDTH] = 16777215 - col;
         }
       }
     }else{
       for (int x = 0; x < sprite.Width; x++) {
         int xx = xstart + x;
         if (xx >= MainFile.WIDTH || xx < 0) continue;
         
         
         int col = sprite.pixels[x + y * sprite.Size];
         if(col != -16777216){
           if(tint)
           pixels[xx + yy * MainFile.WIDTH] = col;
           else
           pixels[xx + yy * MainFile.WIDTH] = 16777215 - col;
         }
     }
   }
 }
 }

}
