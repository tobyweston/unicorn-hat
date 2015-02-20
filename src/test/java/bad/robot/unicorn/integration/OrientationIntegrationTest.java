package bad.robot.unicorn.integration;

import bad.robot.unicorn.Orientation;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import bad.robot.unicorn.shape.Shape;
import bad.robot.unicorn.shape.Arrow;
import bad.robot.unicorn.shape.Cross;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static bad.robot.unicorn.Orientation.*;
import static bad.robot.unicorn.Sleep.sleep;
import static java.awt.Color.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class OrientationIntegrationTest {

	@Test
	public void shouldShowArrowThenRotate() {
		Unicorn unicorn = new NeoPixelDisplayMatrix();
		Shape arrow = new Arrow();

		Stream.of(GPIO_UP, GPIO_RIGHT, GPIO_DOWN, GPIO_LEFT).forEach(orientation -> {
			unicorn.rotate(orientation);
			arrow.draw(green, unicorn);
			sleep(1, SECONDS);
			unicorn.clear();
		});
	}

	public static void main(String... args) {
		new OrientationIntegrationTest().shouldShowArrowThenRotate();
	}

}
