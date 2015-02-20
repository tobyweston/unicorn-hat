package bad.robot.unicorn.shape;

import bad.robot.unicorn.Coordinate;
import bad.robot.unicorn.Unicorn;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static bad.robot.unicorn.Coordinate.coordinate;

public class Arrow implements Shape {

	private final List<Coordinate> coordinates = Arrays.asList(
		coordinate(0, 3), coordinate(0, 4),
		coordinate(1, 2), coordinate(1, 3), coordinate(1, 4), coordinate(1, 5),
		coordinate(2, 1), coordinate(2, 3), coordinate(2, 4), coordinate(2, 6),
		coordinate(3, 0), coordinate(3, 3), coordinate(3, 4), coordinate(3, 7),
		coordinate(4, 3), coordinate(4, 4),
		coordinate(5, 3), coordinate(5, 4),
		coordinate(6, 3), coordinate(6, 4),
		coordinate(7, 3), coordinate(7, 4)
	);

	@Override
	public void draw(Color colour, Unicorn unicorn) {
		coordinates.forEach(coordinate -> unicorn.setPixelColor(coordinate.x, coordinate.y, colour));
		unicorn.show();
	}
}
