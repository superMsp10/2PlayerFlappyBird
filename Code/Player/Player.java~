package Player;

import java.sql.Time;

import graphics.*;
import Code.MainFile;
import inputs.*;

public class Player {
	Sprite Player = new Sprite("/Player.png", 34);
	Keyboard key;
	int x, y;
	float gravity = 9.8f;
	float momenteumY = 0;
	float terminalVelocity = 20f;
	boolean jumped = false;
	float jumpedTime = 0;

	public Player(Keyboard k) {
		key = k;
	}

	public void Render(Display d) {
		d.renderSprite(Player, x, y);
	}

	public void Update() {

		//-----------------Movement----------------//
		if(jumpedTime - System.currentTimeMillis()/1000 < 1)
			jumped = false;
		
		if (key.up && !jumped) {
			momenteumY = -10f;
			gravity = 0;
			jumped = true;
			jumpedTime = System.currentTimeMillis()/1000;

		}
		System.out.println(jumpedTime - System.currentTimeMillis()/1000 );

		if (key.down) {
			y++;
		}
		if (key.left) {
			x--;
		}
		if (key.right) {
			x++;
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

}
