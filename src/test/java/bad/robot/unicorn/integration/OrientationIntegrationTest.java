package bad.robot.unicorn.integration;

import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import bad.robot.unicorn.shape.Arrow;
import bad.robot.unicorn.shape.Shape;
import org.junit.Test;

import java.awt.*;
import java.util.stream.Stream;

import static bad.robot.unicorn.Orientation.*;
import static bad.robot.unicorn.Sleep.sleep;
import static java.awt.Color.*;
import static java.awt.Color.green;
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

	private void shouldShowArrowPointingUp() {
		Unicorn unicorn = new NeoPixelDisplayMatrix();
		Shape arrow = new Arrow();
		unicorn.rotate(GPIO_UP);
		arrow.draw(cyan, unicorn);
	}

	public static void main(String... args) {
		new OrientationIntegrationTest().shouldShowArrowPointingUp();
	}

}
