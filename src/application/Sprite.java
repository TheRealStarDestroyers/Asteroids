package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class Sprite {

	/**
	 * 
	 * vector position -> parameter for calculating the position in the game 
	 * vector velocity -> parameter for the speed on the axis
	 * rotation -> parameter to calculate the rotation in degrees
	 * boundary -> to keep the border separated
	 * image -> for input an .png data
	 * elapsedTime -> time dependent on system time / elapsed in seconds 
	 * 
	 */
	
	public Vector position;
	public Vector velocity;
	public double rotation; // degrees
	public Rectangle boundary;
	public Image image;
	public double elapsedTime; // sec

	public Sprite() {
		this.position = new Vector();
		this.velocity = new Vector();
		this.rotation = 0;
		this.boundary = new Rectangle();
		this.elapsedTime = 0;

	}
			/**
			 * the method below is for set an input stream (images) and scale the size of the image  
			 */
	public void setImage(String imageFileName, double w, double h, boolean ratio, boolean smooth) {
		this.image = new Image(getImageURL(imageFileName), 0, 0, false, false);
		this.boundary.setSize(this.image.getWidth(), this.image.getHeight());
	}

	/**
	 * method to calculate the exact position
	 * @return the exact position
	 */
	
	public Rectangle getBoundry() {
		this.boundary.setPosition(this.position.x, this.position.y);
		return this.boundary;
	}

	/**
	 * method to check if one object is over an other
	 * @param other
	 * @return if they cross
	 */
	public boolean overlaps(Sprite other) {
		return this.getBoundry().overlaps(other.getBoundry());
	}

	/**
	 * function to warp the objects between top/bottom left/right edge
	 * @param screenWidth
	 * @param screenHeigth
	 */
	
	public void wrap(double screenWidth, double screenHeigth) {
		double halfWidth = this.image.getWidth() / 2;
		double halfHeight = this.image.getHeight() / 2;

		if (this.position.x + halfWidth < 0)
			this.position.x = screenWidth + halfWidth;
		if (this.position.x > screenWidth + halfWidth)
			this.position.x = -halfWidth;
		if (this.position.y + halfHeight < 0)
			this.position.y = screenHeigth + halfHeight;
		if (this.position.y > screenHeigth + halfHeight)
			this.position.y = -halfHeight;
	}
	
	/**
	 * increase elapsed time for this sprite
	 * @param deltaTime
	 * 
	 * increase elapsed time for this sprite
	 * 
	 * initialized the warp around screen by screen size
	 */

	public void uptdate(double deltaTime) {
		this.elapsedTime += deltaTime;

		this.position.add(this.velocity.x * deltaTime, this.velocity.y * deltaTime);

		this.wrap(800, 600);
	}
	
	
	/**
	 * method to safe the position of the objects on screen an keep them updated
	 */

	public void render(GraphicsContext context) {
		context.save();

		context.translate(this.position.x, this.position.y);
		context.rotate(this.rotation);
		context.translate(-this.image.getWidth() / 2, -this.image.getHeight() / 2);
		context.drawImage(this.image, 0, 0);

		context.restore();
	}
	
	/**
	 * 
	 * @param relativeImagePath
	 * @return the path of the image in an external form
	 */

	public static String getImageURL(String relativeImagePath) {
		return Sprite.class.getResource(relativeImagePath).toExternalForm();
	}
}
