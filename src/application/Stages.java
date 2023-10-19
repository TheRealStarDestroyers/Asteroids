package application;

import java.util.List;

import javafx.scene.canvas.GraphicsContext;

public class Stages {

	/**
	 * stage -> for counting the stages you are going threw the game see at main doc
	 * little adjustment at every level (velocity and number of objects)
	 */
	public boolean gameOver = false;
	public boolean YouWin = true;
	Signs sign = new Signs();
	int stage = 1;

	public void stageOne(List<Sprite> asteroidList, int stage) {
		int aseroidCount = 6;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(50);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageTwo(List<Sprite> asteroidList) {

		int aseroidCount = 8;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(70);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageThree(List<Sprite> asteroidList) {
		int aseroidCount = 10;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(90);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageFour(List<Sprite> asteroidList) {
		int aseroidCount = 12;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(130);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageFive(List<Sprite> asteroidList) {
		int aseroidCount = 12;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(180);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageSix(List<Sprite> asteroidList) {
		int aseroidCount = 15;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(150);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageSeven(List<Sprite> asteroidList) {
		int aseroidCount = 15;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(150);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageEight(List<Sprite> asteroidList) {
		int aseroidCount = 16;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(170);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageNine(List<Sprite> asteroidList) {
		int aseroidCount = 18;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(180);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageTen(List<Sprite> asteroidList) {
		int aseroidCount = 12;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(250);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}
	}

	public void stageEleven(List<Sprite> asteroidList) {
		int aseroidCount = 12;
		for (int n = 0; n < aseroidCount; n++) {
			Sprite asteroid = new Sprite();
			asteroid.setImage("images/asteroid.png", 64, 64, true, true);
			double x = 500 * Math.random() + 300;
			double y = 400 * Math.random() + 100;
			asteroid.position.set(x, y);
			double angle = 360 * Math.random();
			asteroid.velocity.setLength(300);
			asteroid.velocity.setAngle(angle);
			asteroidList.add(asteroid);
		}

	}

	/**
	 * function to update after the asteroidsList is empty and the stage gets an
	 * update
	 * 
	 * is adding asteroids to the screen
	 * 
	 * @param asteroidList
	 * -> stores all the asteroids in list
	 * @param stage
	 * -> is counting the stages up to twelve
	 */

	public void newStage(List<Sprite> asteroidList, int stage, GraphicsContext gc, int score) {
		switch (stage) {
		case 1:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageTwo(asteroidList);
				stage += 1;
			}
			break;
		case 3:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageThree(asteroidList);
				stage += 1;
			}
			break;
		case 4:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageFour(asteroidList);
				stage += 1;
			}
			break;
		case 5:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageFive(asteroidList);
				stage += 1;
			}
			break;
		case 6:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageSix(asteroidList);
				stage += 1;
			}
			break;
		case 7:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageSeven(asteroidList);
				stage += 1;
			}
			break;
		case 8:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageEight(asteroidList);
				stage += 1;
			}
			break;
		case 9:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageNine(asteroidList);
				stage += 1;
			}
			break;
		case 10:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageTen(asteroidList);
				stage += 1;
			}
			break;
		case 11:
			if (asteroidList.isEmpty()) {
				Stages playstage = new Stages();
				playstage.stageEleven(asteroidList);
				stage += 1;
				break;
			}
		case 12:
			if (asteroidList.isEmpty() && YouWin) {
				gameOver = true;
				sign.showYouWinAndScore(gc, stage, score);
				sign.showClickForRestart(gc);
				
			}
			break;
		default:
			break;
		}
	}
}
