package bad.robot.unicorn.integration;

import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import org.junit.Test;

import java.awt.*;

import static java.lang.Math.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.DoubleStream.iterate;
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

    @Test
    public void shouldShowColoursOfTheRainbowSwirling() {
        Unicorn unicorn = new NeoPixelDisplayMatrix();
        iterate(0, i -> i + 0.3).limit(100).forEach(i -> {
            range(0, 8).forEach(y -> {
                range(0, 8).forEach(x -> {
                    float xy = x + y / 4;
                    float r = toFloat((cos((x + i) / 2.0) + cos((y + i) / 2.0)) * 64 + 128);
                    float g = toFloat((sin((x + i) / 1.5) + sin((y + i) / 2.0)) * 64 + 128);
                    float b = toFloat((sin((x + i) / 2.0) + cos((y + i) / 1.5)) * 64 + 128);
                    unicorn.setPixelColor(x, y, new Color(r, g, b));
                });
            });
            unicorn.show();
            Sleep.sleep(10, MILLISECONDS);
        });
        unicorn.shutdown();
    }

    private static float toFloat(Double value) {
        int offset = 30;
        float asFloat = value.floatValue();
        return max(0, min(255, asFloat + offset));
    }

    public static void main(String... args) {
        new RainbowIntegrationTest().shouldShowColoursOfTheRainbowSwirling();
    }
}
