package handlers;

public class ActionHandler implements IActionHandler {

	public double circleArea(double radius) {
		return (Math.PI * Math.pow(radius, 2.0));
	}

	public double rectangleArea(double length, double width) {
		return length * width;
	}

	public double triangleArea(double length, double width, int degreeAngle) {
		return 0.5 * length * width * Math.sin(degreeAngle * Math.PI / 180);
	}

	public double ballVolume(double radius) {
		// Don't forget to divide double to avoid losing precision.
		return (4.0/3.0) * Math.PI * Math.pow(radius, 3.0);
	}
}
