package bad.robot.unicorn.integration;

import bad.robot.unicorn.Gaussian;
import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import bad.robot.unicorn.neopixel.ws2812.Ws2812Unicorn;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static bad.robot.unicorn.integration.CommandLine.*;
import static bad.robot.unicorn.neopixel.PlatformSafeUnicorn.createPlatformSafeUnicorn;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.IntStream.range;

public class PulseIntegrationTest {

	@Test
	public void shouldPulse() {
        shouldPulse(createPlatformSafeUnicorn(Ws2811Unicorn::new));
	}

    private void shouldPulse(Unicorn unicorn) {
        System.out.println(unicorn.getBrightness());
        List<Integer> zs = Arrays.asList(4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        zs.stream().forEach(z -> {
            double radius = 5 / z;
            double[][] gauss = Gaussian.create(radius, 3.5, 3.5);

            range(0, 100).forEach(count -> {
                range(0, 8).forEach(y -> {
                    range(0, 8).forEach(x -> {
                        float hue = 0.8f;
                        float saturation = 0.8f;
                        float brightness = new Double(gauss[x][y]).floatValue();
                        int rgb = Color.HSBtoRGB(hue, saturation, brightness);
                        Color colour = new Color(rgb);
                        unicorn.setPixelColor(x, y, colour);
                    });
                });
            });
            unicorn.show();
            Sleep.sleep(5, MILLISECONDS);
        });

        unicorn.shutdown();
    }

    public static void main(String... args) {
		new PulseIntegrationTest().shouldPulse(createUnicorn(args));
	}
}
