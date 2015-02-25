package bad.robot.unicorn.integration;

import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2812.Ws2812Unicorn;
import org.junit.Test;

import java.awt.*;

import static bad.robot.unicorn.Sleep.sleep;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BasicIntegrationTest {

	@Test
	public void switchOnEachLedInSequence() throws InterruptedException {
		Unicorn unicorn = new Ws2812Unicorn();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				unicorn.setPixelColor(x, y, Color.magenta);
				unicorn.show();
				sleep(50, MILLISECONDS);
			}
		}
		sleep(1, SECONDS);
		unicorn.shutdown();
	}

	public static void main(String... args) throws InterruptedException {
		new BasicIntegrationTest().switchOnEachLedInSequence();
	}

}
