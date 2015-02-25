package bad.robot.unicorn.integration;

import bad.robot.unicorn.Gaussian;
import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2812.Ws2812Unicorn;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.IntStream.range;

public class RainbowBlinkyIntegrationTest {

    @Test
    public void showColoursOfTheRainbowAndBlink() {
        Unicorn unicorn = new Ws2812Unicorn();

        List<Integer> zs = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        zs.stream().forEach(z -> {
            double radius = 5 / z;
            double[][] gauss = Gaussian.create(radius, 3.5, 3.5);
            range(0, 8).forEach(y -> {
                range(0, 8).forEach(x -> {
                    float hue = 1.0f / (x + y + 1);
                    float saturation = 0.8f;
                    float brightness = new Double(gauss[x][y]).floatValue();
                    int rgb = Color.HSBtoRGB(hue, saturation, brightness);
                    Color colour = new Color(rgb);
                    unicorn.setPixelColor(x, y, colour);
                });
            });
            unicorn.show();
            Sleep.sleep(5, MILLISECONDS);
        });
    }

	public static void main(String... args) {
		new RainbowBlinkyIntegrationTest().showColoursOfTheRainbowAndBlink();
	}
}
