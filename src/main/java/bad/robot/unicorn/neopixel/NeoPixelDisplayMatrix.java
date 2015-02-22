package bad.robot.unicorn.neopixel;

import bad.robot.unicorn.Orientation;
import bad.robot.unicorn.Unicorn;

import java.awt.*;

import static bad.robot.unicorn.Orientation.UP;
import static java.util.stream.IntStream.range;

public class NeoPixelDisplayMatrix implements Unicorn {

	private final PixelIndexMatrix matrix = new PixelIndexMatrix();

	private Orientation orientation = UP;

	public NeoPixelDisplayMatrix() {
		ws2812.init(64);
	}

    @Override
    public void setPixelColor(int x, int y, Color colour) {
        long index = matrix.getIndexFrom(x, y, orientation);
        setPixelColor(index, colour);
    }

	/* doesn't respect orientation */
	@Override
	public void setPixelColor(long pixel, Color colour) {
		ws2812.setPixelColor(pixel, (short) colour.getRed(), (short) colour.getGreen(), (short) colour.getBlue());
	}

	@Override
	public void setBrightness(double brightness) {
		if (brightness < 0 || brightness > 1)
			throw new IllegalArgumentException("Brightness should be between 0.0 and 1.0");
		ws2812.setBrightness(brightness);
	}

	@Override
	public double getBrightness() {
		return ws2812.getBrightness();
	}

	@Override
    public void rotate(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public void show() {
        ws2812.show();
    }

	@Override
	public void clear() {
		range(0, 64).forEach(pixel -> ws2812.setPixelColor(pixel, (short) 0, (short) 0, (short) 0));
		show();
	}

	@Override
	public void shutdown() {
		clear();
		ws2812.terminate(0);
	}
}
