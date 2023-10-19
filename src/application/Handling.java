package application;

import java.util.List;

public class Handling {
	/*
	 * the function handle, stores all of the input in the lists
	 * 
	 * "LEFT" -> is rotating the spaceship 3 times 60f per second to the left
	 * "RIGHT" -> is rotating the spaceship 3 times 60f per second to the right "UP"
	 * -> sets the velocity of the objects length in the direction witch is ahead
	 * "SPACE" -> every tab appears a new "laser-point", in the direction witch is
	 * ahead also when "gameOver"n turns true, no "laser-point" will be added to the
	 * laserList
	 */
	
	public void handlingSpaceShip(List<String> keyPressedList, List<String> keyJustPressedList, List<Sprite> laserlist,
			Sprite spaceship, boolean gameOver) {
		if (keyPressedList.contains("LEFT")) {
			spaceship.rotation -= 3;
		}
		if (keyPressedList.contains("RIGHT")) {
			spaceship.rotation += 3;
		}
		if (keyPressedList.contains("UP")) {
			spaceship.velocity.setLength(150);
			spaceship.velocity.setAngle(spaceship.rotation);
		} else {
			spaceship.velocity.setLength(0);
		}

		if (keyJustPressedList.contains("SPACE") && gameOver != true) {
			Sprite laser = new Sprite();
			laser.setImage("images/laser.png", 1, 1, true, true);
			laser.position.set(spaceship.position.x, spaceship.position.y);
			laser.velocity.setLength(400);
			laser.velocity.setAngle(spaceship.rotation);
			laserlist.add(laser);
		}

	}

}
