package bad.robot.unicorn.shape;

import bad.robot.unicorn.Unicorn;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Cross implements Shape {

	private final List<Integer> pixels = Arrays.asList(7, 56, 9, 54, 21, 42, 27, 36, 28, 35, 18, 45, 14, 49, 0, 63);

	@Override
	public void draw(Color colour, Unicorn unicorn) {
		pixels.forEach(pixel -> unicorn.setPixelColor(pixel, colour));
		unicorn.show();
	}
}
