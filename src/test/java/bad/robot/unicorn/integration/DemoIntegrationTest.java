package bad.robot.unicorn.integration;

import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import org.junit.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static bad.robot.unicorn.integration.CommandLine.createUnicorn;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.IntStream.range;

public class DemoIntegrationTest {

	@Test
	public void swirlyGoodness() {
		swirlyGoodness(new Ws2811Unicorn());
	}

	private void swirlyGoodness(Unicorn unicorn) {
		Swirl effect = new Swirl();
		unicorn.setBrightness(0.05);

		while (true) {
			range(0, 500).forEach(step -> {
				range(0, 8).forEach(y -> {
					range(0, 8).forEach(x -> {
						RawColour colour = effect.getColourFor(x, y, step);
						double red = Math.max(0, Math.min(255, colour.red));
						double green = Math.max(0, Math.min(255, colour.green));
						double blue = Math.max(0, Math.min(255, colour.blue));
						unicorn.setPixelColor(x, y, new Color(Color.HSBtoRGB((float) red, (float) green, (float) blue)));
					});
				});
				// step
				unicorn.show();
				Sleep.sleep(10, MILLISECONDS);
			});
			// rotate effect
		}
	}

	public static void main(String... args) {
		new DemoIntegrationTest().swirlyGoodness(createUnicorn(args));
	}

	interface Effect {
		RawColour getColourFor(int x, int y, int step);
	}

	public class Swirl implements Effect {

		public RawColour getColourFor(int x, int y, int step) {
			x -= 4;
			y -= 4;

			double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) - 2.0;
			double angle = (step / 10.0) + (dist * 1.5);
			double s = Math.sin(angle);
			double c = Math.cos(angle);

			double xs = x * c - y * s;
			double ys = x * s - y * c;

			double r = Math.abs(xs + ys);
			r *= 64.0;
			r -= 20;

			return new RawColour(r, r + (s * 130), r + (c * 130));
		}
	}

	class RawColour {
		final double red;
		final double green;
		final double blue;

		public RawColour(double red, double green, double blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}

	}

}
