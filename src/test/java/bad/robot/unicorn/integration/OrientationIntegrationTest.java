package bad.robot.unicorn.integration;

import bad.robot.unicorn.Orientation;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import bad.robot.unicorn.neopixel.ws2812.Ws2812Unicorn;
import bad.robot.unicorn.shape.Arrow;
import bad.robot.unicorn.shape.Shape;
import org.junit.Test;

import java.awt.*;
import java.util.stream.Stream;

import static bad.robot.unicorn.Orientation.*;
import static bad.robot.unicorn.Sleep.sleep;
import static bad.robot.unicorn.integration.CommandLine.*;
import static bad.robot.unicorn.neopixel.PlatformSafeUnicorn.createPlatformSafeUnicorn;
import static java.awt.Color.*;
import static java.awt.Color.green;
import static java.util.concurrent.TimeUnit.SECONDS;

public class OrientationIntegrationTest {

	@Test
	public void shouldShowArrowThenRotate() {
        shouldShowArrowThenRotate(createPlatformSafeUnicorn(Ws2811Unicorn::new));
    }

    private void shouldShowArrowThenRotate(Unicorn unicorn) {
        Shape arrow = new Arrow();
        Stream.of(UP, RIGHT, DOWN, LEFT).forEach(orientation -> {
            unicorn.rotate(orientation);
            arrow.draw(green, unicorn);
            sleep(1, SECONDS);
            unicorn.clear();
        });
        unicorn.shutdown();
    }

    public static void main(String... args) {
        new OrientationIntegrationTest().shouldShowArrowThenRotate(createUnicorn(args));
    }

}
