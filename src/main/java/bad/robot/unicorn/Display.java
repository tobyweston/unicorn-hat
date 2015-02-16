package bad.robot.unicorn;

import bad.robot.unicorn.ws2812.ws2812;

import java.awt.*;

import static bad.robot.unicorn.Orientation.*;

public class Display {

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


	private Orientation orientation = GPIO_UP;

	public long getIndexFrom(int x, int y) {
		if (orientation.degrees() == 90) {
			return matrix[7 - x][y];
		} else if (orientation.degrees() == 180) {
			return matrix[7 - x][7 - y];
		} else if (orientation.degrees() == 270) {
			return matrix[x][7 - y];
		}
		return matrix[x][y];
	}

	public void setPixelColor(int x, int y, Color colour) {
		long index = getIndexFrom(x, y);
		ws2812.setPixelColor(index, (short) 255, (short) 0, (short) 255);
	}

	public void rotate(Orientation orientation) {
		this.orientation = orientation;
	}
}
