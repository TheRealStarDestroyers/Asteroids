package application;

public class Rectangle {

	/**
	 * (x,y) represens top-left corner of Rectangle
	 * 
	 */
	
	double x;
	double y;
	double width;
	double height;

	public Rectangle() {
		this.setPosition(0, 0);
		this.setSize(1, 1);
	}

	public Rectangle(double x, double y, double w, double h) {
		this.setPosition(x, y);
		this.setSize(w, h);
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;

	}

	/**
	 * 
	 * @param w
	 * @param h
	 */
	public void setSize(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 * returns that all of the following options are covered
	 * 
	 * Four cases where these is no overLap
	 * 1: this to the left of other
	 * 2: this.to the right of other
	 * 3: this is above other
 	 * other is above this
	 * 
	 */

	public boolean overlaps(Rectangle other) {

		boolean noOverlap = this.x + this.width < other.x || other.x + other.width < this.x
				|| this.y + this.height < other.y || other.y + other.height < this.y;
		return !noOverlap;
	}

}
