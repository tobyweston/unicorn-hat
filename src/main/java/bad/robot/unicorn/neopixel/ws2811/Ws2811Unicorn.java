package bad.robot.unicorn.neopixel.ws2811;

import bad.robot.unicorn.Orientation;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.PixelIndexMatrix;

import java.awt.*;

import static bad.robot.unicorn.Orientation.UP;
import static java.util.stream.IntStream.range;

public class Ws2811Unicorn implements Unicorn {

	private final AdafruitNeoPixel adafruit = new AdafruitNeoPixel(64, 18, 800000, 5, false, 255, 0);
	private final PixelIndexMatrix matrix = new PixelIndexMatrix();

	private Orientation orientation = UP;

	public Ws2811Unicorn() {
		adafruit.begin();
	}

    @Override
    public void setPixelColor(int x, int y, Color colour) {
        long index = matrix.getIndexFrom(x, y, orientation);
        setPixelColor(index, colour);
    }

	/* doesn't respect orientation */
	@Override
	public void setPixelColor(long pixel, Color colour) {
		adafruit.setPixelColor((int) pixel, (short) colour.getRed(), (short) colour.getGreen(), (short) colour.getBlue());
	} // TODO change interface to be an int and cast up in other lib if needed

	@Override
	public void setBrightness(double brightness) {
		if (brightness < 0 || brightness > 1)
			throw new IllegalArgumentException("Brightness should be between 0.0 and 1.0");
		adafruit.setBrightness(brightness);
	}

	@Override
	public double getBrightness() {
		return adafruit.getBrightness();
	}

	@Override
    public void rotate(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void show() {
        adafruit.show();
    }

	@Override
	public void clear() {
		range(0, 64).forEach(pixel -> adafruit.setPixelColor(pixel, (short) 0, (short) 0, (short) 0));
		show();
	}

	@Override
	public void shutdown() {
		clear();
		show();
	}
}
