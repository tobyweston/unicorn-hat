package bad.robot.unicorn.neopixel;

import bad.robot.unicorn.Coordinate;
import bad.robot.unicorn.Orientation;

public class PixelIndexMatrix {

	private final Integer[][] matrix = new Integer[][]{
		{7,   6,  5,  4,  3,  2,  1,  0},
		{8,   9, 10, 11, 12, 13, 14, 15},
		{23, 22, 21, 20, 19, 18, 17, 16},
		{24, 25, 26, 27, 28, 29, 30, 31},
		{39, 38, 37, 36, 35, 34, 33, 32},
		{40, 41, 42, 43, 44, 45, 46, 47},
		{55, 54, 53, 52, 51, 50, 49, 48},
		{56, 57, 58, 59, 60, 61, 62, 63}
	};

	public long getIndexFrom(int x, int y, Orientation orientation) {
		Coordinate rotated = orientation.getCoordinateFrom(x, y);
		return matrix[rotated.x][rotated.y];
	}

}
