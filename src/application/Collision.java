package application;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;



public class Collision {

	public boolean hit = false;
	Stages stage = new Stages();

	/**
	 * @param laserlist    -> keeps all the lasers witch appear when "SPACE" is
	 *                     clicked
	 * @param asteroidList -> stores all asteroids in list -> when list is empty,
	 *                     start new stage
	 * @return -> when a collision is detected, remove both objects from list and
	 *         count the score
	 */
	public int collisionAsteroidLaser(List<Sprite> laserlist, List<Sprite> asteroidList) {
		for (int laserNum = 0; laserNum < laserlist.size(); laserNum++) {
			Sprite laser = laserlist.get(laserNum);
			for (int asteroidNum = 0; asteroidNum < asteroidList.size(); asteroidNum++) {
				Sprite asteroid = asteroidList.get(asteroidNum);
				if (laser.overlaps(asteroid)) {
					hit = true;
					laserlist.remove(laserNum);
					asteroidList.remove(asteroidNum);
				}
				if (laser.overlaps(asteroid) && hit == true) {
					return 100;
				}
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param spaceshipList -> keeps the sprite spaceship once in list
	 * @param asteroidList  -> stores all asteroids in list
	 * @param gameOver      -> if no life is left, game is over
	 * @return -> decreases the life count after a collision of an asteroid and the
	 *         spaceship also the function is reseting the position of the spaceship
	 */
	public int collisionSpaceshipAsteroid(List<Sprite> spaceshipList, List<Sprite> asteroidList, boolean gameOver,
			GraphicsContext gc) {
		for (int spaceshipNum = 0; spaceshipNum < spaceshipList.size(); spaceshipNum++) {
			Sprite spaceship = spaceshipList.get(spaceshipNum);
			for (int asteroidNum = 0; asteroidNum < asteroidList.size(); asteroidNum++) {
				Sprite asteroid = asteroidList.get(asteroidNum);
				if (asteroid.overlaps(spaceship) && gameOver != true) {
					asteroidList.remove(asteroid);
					spaceship.position.set(100, 300);
					spaceship.velocity.set(50, 0);
					return 1;
				}
				
			}
		}
		return 0;
	}
}
