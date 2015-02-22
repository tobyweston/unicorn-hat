package bad.robot.unicorn;

import java.awt.*;

public class StubUnicorn implements Unicorn {

	@Override
	public void setPixelColor(int x, int y, Color colour) {
		System.out.printf("(%s,%s) : %s%n", x, y, colour);
	}

	@Override
	public void setPixelColor(long pixel, Color color) {
	}

	@Override
	public void setBrightness(double brightness) {
	}

	@Override
	public double getBrightness() {
		return 0;
	}

	@Override
	public void show() {
	}

	@Override
	public void rotate(Orientation orientation) {
	}

	@Override
	public void clear() {
	}

	@Override
	public void shutdown() {
	}
}
