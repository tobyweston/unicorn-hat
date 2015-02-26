package bad.robot.unicorn.integration;

import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import bad.robot.unicorn.shape.Arrow;
import bad.robot.unicorn.shape.Shape;
import org.junit.Test;

import java.awt.*;
import java.util.stream.Stream;

import static bad.robot.unicorn.Orientation.*;
import static bad.robot.unicorn.Sleep.sleep;
import static bad.robot.unicorn.integration.CommandLine.createUnicorn;
import static java.util.concurrent.TimeUnit.SECONDS;

public class OrientationIntegrationTest {

	@Test
	public void shouldShowArrowThenRotate() {
        shouldShowArrowThenRotate(new Ws2811Unicorn());
    }

    private void shouldShowArrowThenRotate(Unicorn unicorn) {
        Shape arrow = new Arrow();
        Stream.of(UP, RIGHT, DOWN, LEFT).forEach(orientation -> {
            unicorn.rotate(orientation);
            arrow.draw(new Color(0, 255, 0), unicorn);
            sleep(1, SECONDS);
            unicorn.clear();
        });
        unicorn.shutdown();
    }

    public static void main(String... args) {
        new OrientationIntegrationTest().shouldShowArrowThenRotate(createUnicorn(args));
    }

}
