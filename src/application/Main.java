package application;


import java.util.ArrayList;
import java.util.logging.Logger;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 * 
 * 
 *
 */
public class Main extends Application {
	
	 public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	/**
	 * variables score -> is for score count;
	 */
	public int score;
	/**
	 * stage = 1; -> is for stage count;
	 */
	int stage = 1;
	/**
	 * lifeCount = 3; -> shows the life you start with;
	 */
	public int lifeCount = 3;
	/**
	 * boolean youWin; -> turns true if you cleared stage 12;
	 */
	public boolean youWin = false;
	/**
	 * gameOver = false; -> turns true if lifeCount turn zero;
	 */
	public boolean gameOver = false;
	/**
	 * collisions = false; -> turns true if a collision is detected;
	 */
	public boolean collisions = false;
	/**
	 * sign -> create an object to get all the shown signs;
	 */
	Signs sign = new Signs();
	/**
	 * stage1 -> create an object to get all of the stages;
	 */
	Stages stage1 = new Stages();
	/**
	 * collision -> create an object to count score an lives, when collision is
	 * detected
	 */
	Collision collision = new Collision();
	/**
	 * spaceship -> instance of the spaceship
	 */
	private Sprite spaceship;
	/**
	 * instance of the laser
	 */
	private Sprite laser;
	/**
	 * AnimationTimer -> create the game loop
	 */
	private AnimationTimer gameloop;
	/**
	 * instance of the background
	 */
	private Sprite background;
	
	
	private final String TABLENAME = "USER";
	private final String COLUMNNAME = "username";
	private final String FINDTHIS = "password";
		
	
	/**
	 * In the start function is implemented a try catch function for get the game
	 * start - also avoids the printStackTrace Exception
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	/**
	 * restart -> is reseting all instances witch are necessary for the game and
	 * restarts the game loop
	 * 
	 * @param mainStage
	 */
	private void restart(Stage mainStage) {
		if (gameOver) {
			lifeCount = 3;
			stage = stage - 1;
			score = 0;
			youWin = false;
			gameOver = false;
			collisions = false;
			spaceship.position.set(100, 300);
			spaceship.velocity.set(50, 0);
			gameloop.start();
		}
	}
	/**
	 * start -> creates one time all instances in the game, defines the background,
	 * and start the game loop
	 */
	@Override
	public void start(Stage mainStage) {
		
		/**
		 * instance of login 
		 */
		Login login = new Login();
		
		try {
			DbConnection.retrieveByString(TABLENAME, COLUMNNAME, FINDTHIS);
			LOGGER.info("Connection successful");
		} catch (Exception e) {
			LOGGER.warning("Connection failed" + e);
		}
		
		
		/*
		 * the mainStage creates the application surface, in this case "canvas" sets the
		 * parameter(width/height)
		 */
		mainStage.setTitle("Asteroids");
		BorderPane root = new BorderPane();
		Scene mainScene = new Scene(root);
		
		mainStage.setScene(mainScene);
		login.loginScreen(mainStage);
		
		
		
		
		

		Canvas canvas = new Canvas(800, 600);
		

		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.setCenter(canvas);
		canvas.setOnMouseClicked(e -> restart(mainStage));
		/*
		 * keyPressedList -> handle continuous inputs (as long as key is pressed)
		 * 
		 * keyJustPressedList -> handle discrete inputs (once per key press)
		 * 
		 */
		ArrayList<String> keyPressedList = new ArrayList<String>();

		ArrayList<String> keyJustPressedList = new ArrayList<String>();

		mainScene.setOnKeyPressed((KeyEvent event) -> {
			String keyName = event.getCode().toString();
			// Avoid adding duplicates to list

			if (!keyPressedList.contains(keyName)) {
				keyPressedList.add(keyName);
				keyJustPressedList.add(keyName);
			}
		});
		mainScene.setOnKeyReleased((KeyEvent event) -> {
			String keyName = event.getCode().toString();

			if (keyPressedList.contains(keyName)) {
				keyPressedList.remove(keyName);
				keyJustPressedList.remove(keyName);
			}
		});
		background = new Sprite();
		background.setImage("images/space.png", 800, 600, false, false);
		background.position.set(400, 300);

		ArrayList<Sprite> spaceshipList = new ArrayList<Sprite>();
		spaceship = new Sprite();
		spaceship.setImage("images/spaceship.png", 64, 64, true, true);
		spaceship.position.set(100, 300);
		spaceship.velocity.set(50, 0);
		spaceshipList.add(spaceship);

		laser = new Sprite();
		laser.setImage("images/laser.png", 1, 1, true, true);
		laser.position.set(spaceship.position.x, spaceship.position.y);
		laser.velocity.setLength(400);
		laser.velocity.setAngle(spaceship.rotation);

		ArrayList<Sprite> laserlist = new ArrayList<Sprite>();
		ArrayList<Sprite> asteroidList = new ArrayList<Sprite>();
		
		/*
		 * the next section is starting the first stage with 6 asteroids they are
		 * randomly appear by an field in the upper right corner
		 * 
		 * the get also listed in the "asteroidList"
		 * 
		 * stage one has to be called one time outside of the game loop
		 */
		stage1.stageOne(asteroidList, stage);

		gameloop = new AnimationTimer() {
			@Override
			public void handle(long nanotime) {
				Main.this.handle(mainStage, canvas, gc, keyPressedList, keyJustPressedList, spaceshipList, laserlist,
						asteroidList);
			}
		};

		/*
		 * gameloop.start -> starts the game loop mainStage.show -> shows the window
		 */
		gameloop.start();
		mainStage.show();
	}
	/**
	 * 
	 * @param mainStage          -> JavaFX grounding to get a UI
	 * @param canvas             -> defines the size of the UI and keeps the background                         
	 * @param gc                 ->is for showing all the graphic content
	 * @param keyPressedList     -> keeps all keys witch are pressed
	 * @param keyJustPressedList -> keeps all keys witch are pressed in the past
	 * @param spaceshipList      -> keeps the sprite spaceship once in list
	 * @param laserlist          -> keeps all the lasers witch appear when "SPACE" is clicked                  
	 * @param asteroidList       -> stores all asteroids in list -> when list is empty, start new stage                        
	 */
	private void handle(Stage mainStage, Canvas canvas, GraphicsContext gc, ArrayList<String> keyPressedList,
			ArrayList<String> keyJustPressedList, ArrayList<Sprite> spaceshipList, ArrayList<Sprite> laserlist,
			ArrayList<Sprite> asteroidList) {
		// process user input
		Handling handle = new Handling();
		handle.handlingSpaceShip(keyPressedList, keyJustPressedList, laserlist, spaceship, gameOver);
		/*
		 * after all the input from the keyboard, there are two "for-loops" to clear the
		 * user input directly and keep the spaceship and asteroids updated
		 * 
		 */
		keyJustPressedList.clear();

		for (Sprite spaceship : spaceshipList) {
			spaceship.uptdate(1 / 60.0);
		}
		for (Sprite asteroid : asteroidList) {
			asteroid.uptdate(1 / 60.0);
		}
		/*
		 * laser doesn't last forever, the for-loop is for updating the laser and the
		 * function below is for removing the laser after a count of 2 seconds
		 */
		for (int n = 0; n < laserlist.size(); n++) {
			Sprite oneLaser = laserlist.get(n);
			oneLaser.uptdate(1 / 60.0);
			if (oneLaser.elapsedTime > 2)
				laserlist.remove(n);
		}
		/*
		 * the following for-loops are for "comparing" the asteroids and lasers position
		 * 
		 * if there on the same spot - both will be removed from the lists
		 */
		score += collision.collisionAsteroidLaser(laserlist, asteroidList);
		/*
		 * if there is a collision between the spaceship and an asteroid, the asteroid
		 * will be removed from the list and the lifeCount will be decreased by one. the
		 * spaceship will get an reset to the start spot
		 */
		lifeCount -= collision.collisionSpaceshipAsteroid(spaceshipList, asteroidList, gameOver, gc);
		/*
		 * the loops below are keeping the lists updated
		 * 
		 */
		background.render(gc);
		for (Sprite spaceship : spaceshipList)
			spaceship.render(gc);
		for (Sprite oneLaser : laserlist)
			oneLaser.render(gc);
		for (Sprite asteroid : asteroidList)
			asteroid.render(gc);
		/*
		 * dependent on the state of the "gameOver" boolean the function will show the
		 * score and the stage at the Time you loose all your lifeCount goes to 0
		 * 
		 */
		if (lifeCount == 0) {
			gameOver = true;
			sign.showGameOverAndScore(gc, score, stage);
			sign.showClickForRestart(gc);
			gameloop.stop();
		}
		if(stage == 13) {
			stage = 1;
			gameOver = true;
			sign.showYouWinAndScore(gc, score, stage);
			sign.showClickForRestart(gc);
			gameloop.stop();
		}
		/*
		 * the function below depends on the state of the list and the count of the
		 * stages. if the list is empty, a new stage will appear immediately
		 */
		if (asteroidList.isEmpty()) {
			Stages playStages = new Stages();
			playStages.newStage(asteroidList, stage, gc, score);
			stage++;
		}
		/*
		 * dependent on the state of the "gameOver" boolean, the function below shows
		 * score, stage and remaining lives
		 */
		if (gameOver == false) {
			sign.showlifeSign(gc, lifeCount);
			sign.showStageCount(gc, stage);
			sign.showScoreOnScreen(gc, score);
		}
	}
}
