package Player;

import graphics.*;
import Code.MainFile;

public class Player {
  Sprite Player = new Sprite("/Player.png",34);
  int x, y;
  
  
  public Player() { 
    
  }
  
  public void Render(Display d) {
    d.renderSprite(Player,x, y);
  }
  
  public void Update() {

    if(y > MainFile.HEIGHT){
      y = 0;

    }else
      y+= MainFile.GRAVITY;
    
    
  }
  
  
}
