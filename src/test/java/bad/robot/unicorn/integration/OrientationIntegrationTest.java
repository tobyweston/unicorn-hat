package bad.robot.unicorn.integration;

import bad.robot.unicorn.Orientation;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import bad.robot.unicorn.shape.Arrow;
import bad.robot.unicorn.shape.Shape;
import org.junit.Test;

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

		Stream.of(UP, DOWN, GPIO_DOWN, GPIO_LEFT).forEach(orientation -> {
			unicorn.rotate(orientation);
			arrow.draw(green, unicorn);
			sleep(1, SECONDS);
			unicorn.clear();
		});
	}

	private void showArrow(Orientation gpioDown) {
		for (int i = 0; i < 30; i++) {
			Unicorn unicorn = new NeoPixelDisplayMatrix();
			Shape arrow = new Arrow();
			unicorn.rotate(gpioDown);
			arrow.draw(cyan, unicorn);
			sleep(2, SECONDS);
			unicorn.shutdown();
		}
	}

	public static void main(String... args) {
		new OrientationIntegrationTest().showArrow(GPIO_LEFT);
	}

}
