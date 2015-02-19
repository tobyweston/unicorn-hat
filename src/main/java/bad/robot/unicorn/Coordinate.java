package bad.robot.unicorn;

import static java.lang.String.format;

public class Coordinate {
	public final int x;
	public final int y;

	public static Coordinate coordinate(int x, int y) {
		return new Coordinate(x, y);
	}

	private Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return format("(%s, %s)", x, y);
	}
}
