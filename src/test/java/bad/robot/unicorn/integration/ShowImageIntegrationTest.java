package bad.robot.unicorn.integration;

import bad.robot.unicorn.Coordinate;
import bad.robot.unicorn.SpriteSheet;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import static bad.robot.unicorn.Coordinate.coordinate;
import static bad.robot.unicorn.Sleep.sleep;
import static bad.robot.unicorn.integration.CommandLine.createUnicorn;
import static bad.robot.unicorn.neopixel.PlatformSafeUnicorn.createPlatformSafeUnicorn;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.stream.IntStream.range;

/**
 * The tiny 8x8 chars in lofi.png are from Oddball http://forums.tigsource.com/index.php?topic=8834.0
 * <p>
 * Licensed under Creative Commons Attribution-Noncommercial-Share Alike 3.0 Unported License.
 */
public class ShowImageIntegrationTest {

	@Test
	public void displayImages() throws IOException {
        displayImages(createPlatformSafeUnicorn(Ws2811Unicorn::new));
	}

    private void displayImages(Unicorn unicorn) throws IOException {
        SpriteSheet sheet = new SpriteSheet(16, 18, 8, 8);
        BufferedImage[] images = sheet.subImages("/lofi.png");
        Arrays.stream(images).forEach(image -> {
            Stream<Coordinate> _8x8 = range(0, 8).boxed().flatMap(x -> range(0, 8).mapToObj(y -> coordinate(x, y)));
            _8x8.forEach(coordinate -> unicorn.setPixelColor(coordinate.x, coordinate.y, new Color(image.getRGB(coordinate.x, coordinate.y))));
            unicorn.show();
            sleep(500, MILLISECONDS);
        });
    }

    public static void main(String... args) throws IOException {
		new ShowImageIntegrationTest().displayImages(createUnicorn(args));
	}

}
