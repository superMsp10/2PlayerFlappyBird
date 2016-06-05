package Level;

import Code.MainFile;
import graphics.Display;
import graphics.Sprite;

public class Cloud {

 public static Sprite s = new Sprite("/Cloud.png", 50);
 int speed;

 int x;
 int y;

 public Cloud(int _x, int _y,int _speed) {
  x = _x;
  y = _y;
  speed = _speed;
 }

 public void Render(Display d) {
  d.renderSprite(s,x, y);
 }
 
 public void Update() {
   if(x > MainFile.WIDTH){
     x = -50;
   }else
     x+= speed;
 
 }

}
