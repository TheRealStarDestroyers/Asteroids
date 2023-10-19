package application;

public class Vector {

	/**
	 * x -> parameter for x-axis
	 * y -> parameter for y-axis
	 */
	
	public double x;
	public double y;

	/**
	 * 
	 */
	public Vector() {
		this.set(0, 0);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Vector(double x, double y) {
		this.set(x, y);
	}

	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void add(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}

	public void multiply(double m) {
		this.x *= m;
		this.y *= m;

	}

	/**
	 * function to calculate the relevant length of an object on screen
	 * 
	 * @return relevant length
	 */
	public double getLength() {

		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	/**
	 * 
	 * if current length is 0 then current angle is undefined assume current angle
	 * is 0 (pointing to right) else able to preserve current angle scale vector to
	 * have length 1
	 * 
	 * multiply scale vector to have length l
	 * 
	 * 
	 * @param L
	 */

	public void setLength(double L) {

		double currentlength = this.getLength();
		if (currentlength == 0) {
			this.set(L, 0);
		} else {
			this.multiply(1 / currentlength);
			this.multiply(L);
		}
	}

	/**
	 * function to calculate the angle
	 * 
	 * @return exact position
	 */
	public double getAngle() {
		return Math.toDegrees(Math.atan2(this.y, this.x));
	}

	/**
	 * function to calculate the angle of an object (degrees)
	 * 
	 * @param angleDegrees
	 */

	public void setAngle(double angleDegrees) {
		double L = this.getLength();
		double angelRadiance = Math.toRadians(angleDegrees);
		this.x = L * Math.cos(angelRadiance);
		this.y = L * Math.sin(angelRadiance);

	}

}
