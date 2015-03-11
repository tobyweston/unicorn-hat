package bad.robot.unicorn.integration;

import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import bad.robot.unicorn.neopixel.ws2812.Ws2812Unicorn;
import org.junit.After;
import org.junit.Test;

import java.awt.*;

import static bad.robot.unicorn.integration.CommandLine.*;
import static bad.robot.unicorn.neopixel.PlatformSafeUnicorn.createPlatformSafeUnicorn;
import static java.lang.Math.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.DoubleStream.iterate;
import static java.util.stream.IntStream.range;

public class RainbowIntegrationTest {

	@Test
	public void shouldShowSimpleColoursOfTheRainbow() {
        shouldShowSimpleColoursOfTheRainbow(createPlatformSafeUnicorn(Ws2811Unicorn::new));
    }

    @Test
    public void shouldShowFancyColoursOfTheRainbow() {
        shouldShowFancyColoursOfTheRainbow(createPlatformSafeUnicorn(Ws2811Unicorn::new));
    }

    private void shouldShowSimpleColoursOfTheRainbow(Unicorn unicorn) {
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

    private void shouldShowFancyColoursOfTheRainbow(Unicorn unicorn) {
        iterate(0, i -> i + 0.3).limit(500).forEach(i -> {
            range(0, 8).forEach(y -> {
                range(0, 8).forEach(x -> {
                    int r = roundToValueRGBValue((cos((x + i) / 2.0) + cos((y + i) / 2.0)) * 64 + 128);
                    int g = roundToValueRGBValue((sin((x + i) / 1.5) + sin((y + i) / 2.0)) * 64 + 128);
                    int b = roundToValueRGBValue((sin((x + i) / 2.0) + cos((y + i) / 1.5)) * 64 + 128);
                    unicorn.setPixelColor(x, y, new Color(r, g, b));
                });
            });
            unicorn.show();
            Sleep.sleep(10, MILLISECONDS);
        });
        unicorn.shutdown();
    }

	private static int roundToValueRGBValue(Double value) {
		int offset = 30;
		return (int) max(0, min(255, value + offset));
	}

	public static void main(String... args) {
		new RainbowIntegrationTest().shouldShowFancyColoursOfTheRainbow(createUnicorn(args));
	}
}
