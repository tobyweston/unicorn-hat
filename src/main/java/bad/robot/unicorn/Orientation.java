package bad.robot.unicorn;

public enum Orientation {

	UP(0),
	DOWN(90),
	GPIO_DOWN(180),
	GPIO_LEFT(270);

	private final int degrees;

	Orientation(int degrees) {
		this.degrees = degrees;
	}

	public int degrees() {
		return degrees;
	}
}
