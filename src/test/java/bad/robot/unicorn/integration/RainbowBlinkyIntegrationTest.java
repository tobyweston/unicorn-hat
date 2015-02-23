package bad.robot.unicorn.integration;

import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.IntStream.range;

public class RainbowBlinkyIntegrationTest {

    static float[][] makeGaussian(double fullWidthHalfMax, double centerX, double ceterY) {
        return new float[][] {{0}, {0}};
    }

    @Test
    public void showColoursOfTheRainbowAndBlink() {
        Unicorn unicorn = new NeoPixelDisplayMatrix();

        List<Integer> zs = Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        zs.stream().forEach(z -> {
            double fullWidthHalfMax = 5 / z;
            float[][] gauss = makeGaussian(fullWidthHalfMax, 3.5, 3.5);
            range(0, 8).forEach(y -> {
                range(0, 8).forEach(x -> {
                    float h = 1.0f / (x + y + 1);
                    float s = 0.8f;
                    float v = gauss[x][y];
                    int rgb = Color.HSBtoRGB(h, s, v);
                    Color colour = new Color(rgb);
                    unicorn.setPixelColor(x, y, colour);
                });
            });
            unicorn.show();
            Sleep.sleep(5, MILLISECONDS);
        });

    }
}
