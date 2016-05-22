package Level;

import java.util.Random;

import graphics.Display;
import graphics.Sprite;

public class DefaultLevel {

	public Sprite background = new Sprite("/Background.png", 400);
	int numberofClouds = 10;
	Cloud[] clouds = new Cloud[numberofClouds];

	public DefaultLevel() {
		for (int i = 0; i < numberofClouds; i++) {
			Random r = new Random();
			clouds[i] = new Cloud(r.nextInt(400),r.nextInt(150),r.nextInt(2) + 1);
		}
	}

	public void Render(Display screen) {
		screen.renderSprite(background, 0, 0);

		for (Cloud c : clouds) {
			c.Render(screen);
		}
	}

	public void Update() {
		for (Cloud c : clouds) {
			c.Update();
		}
	}

}
