package bad.robot.unicorn.integration;

import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import org.junit.Test;

import java.awt.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.IntStream.range;

public class RainbowIntegrationTest {

	@Test
	public void shouldShowTheColoursOfTheRainbow() {
		Unicorn unicorn = new NeoPixelDisplayMatrix();
		range(0, 360).forEach(z -> {
			range(0, 8).forEach(y -> {
				range(0, 8).forEach(x -> {
					int rgb = Color.HSBtoRGB(z / 360.0F, y / 7.0F, x / 7.0F);
					Color colour = new Color(rgb);
					unicorn.setPixelColor(x, y, colour);
				});
				unicorn.show();
				Sleep.sleep(1, MILLISECONDS);
			});
		});
		unicorn.shutdown();
	}

	public static void main(String... args) {
		new RainbowIntegrationTest().shouldShowTheColoursOfTheRainbow();
	}
}
