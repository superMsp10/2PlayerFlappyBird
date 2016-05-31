package Player;

import java.sql.Time;

import graphics.*;
import Code.MainFile;
import inputs.*;
import java.awt.Rectangle;

public class Player {
 Sprite Player = new Sprite("/Player.png", 34);
 Keyboard key;
 public int x, y;
 float gravity = 9.8f;
 float momenteumY = 0;
 float terminalVelocity = 20f;
 boolean jumped = false;
 long jumpedTime = 0;
 boolean right = true;
 boolean control = false;
 public Rectangle r = new Rectangle(0,0,34,34);


 public Player(Keyboard k, boolean _control, int _x, int _y) {
  key = k;
  control = _control;
  x = _x;
  y = _y;
 }

 public void Render(Display d) {
  d.renderPlayer(Player, x, y, !right, control);
 }

 public void Update() {
   

   r.x = x;
   r.y = y;
   //-----------------Movement----------------//
   if( System.currentTimeMillis() -jumpedTime> 500)
     jumped = false;
   
   
   if(control){
     
     if (key.up && !jumped) {
       jump();
     }
     
     if (key.down) {
       y+=2;
     }
     if (key.left) {
       x-=2;
       right = false;
     }
     if (key.right) {
       x+=2;
       right = true;
     }
     
   }else{
     if (key.up1 && !jumped) {
       jump();
     }
     
     if (key.down1) {
       y+=2;
     }
     if (key.left1) {
       x-=2;
       right = false;
     }
     if (key.right1) {
       x+=2;
       right = true; 
     }
     
   }
   
   //-----------------Gravity----------------//
   if (gravity < MainFile.GRAVITY)
     gravity = (float) (Math.pow(gravity, 1.005d) + 0.1f);
   
   if (momenteumY < terminalVelocity)
     momenteumY += gravity;
   
   //-----------------Pixels----------------//
   y += momenteumY;
   
   if (y > MainFile.HEIGHT) {
     y = 0;
   }
   
   
 }
  
  void jump(){
      momenteumY = -10f;
      gravity = 0;
      jumped = true;
      jumpedTime = System.currentTimeMillis();
 
 }

}
