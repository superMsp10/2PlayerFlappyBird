package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
 private boolean[] keys = new boolean[120];
 public boolean up, down, left, right;
  public boolean up1, down1, left1, right1;
 public static Keyboard defKeyboard = new Keyboard();

 public void update(){
  up =keys[KeyEvent.VK_UP];
  left =keys[KeyEvent.VK_LEFT];
  down =keys[KeyEvent.VK_DOWN];
  right =keys[KeyEvent.VK_RIGHT];
  
    up1 = keys[KeyEvent.VK_W];
  left1 = keys[KeyEvent.VK_A];
  down1 = keys[KeyEvent.VK_S];
  right1 = keys[KeyEvent.VK_D];

 }

 public void keyPressed(KeyEvent e) {
  keys[e.getKeyCode()] = true;
   
 }

 public void keyReleased(KeyEvent e) {
  keys[e.getKeyCode()] = false;


 }

 public void keyTyped(KeyEvent e) {
 

 }

}
