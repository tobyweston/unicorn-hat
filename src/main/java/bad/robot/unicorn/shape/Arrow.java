package bad.robot.unicorn.shape;

import bad.robot.unicorn.Unicorn;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Arrow implements Shape {

	private final List<Integer> pixels = Arrays.asList(24, 39, 22, 25, 38, 41, 10, 26, 37, 53, 4, 27, 36, 59, 28, 35, 29, 34, 30, 33, 31, 32);

	@Override
	public void draw(Color colour, Unicorn unicorn) {
		pixels.forEach(pixel -> unicorn.setPixelColor(pixel, colour));
		unicorn.show();
	}
}
