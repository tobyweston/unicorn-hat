package bad.robot.unicorn.integration;

import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import org.junit.Test;

import java.awt.*;

import static bad.robot.unicorn.Sleep.sleep;
import static java.util.concurrent.TimeUnit.*;

public class BasicIntegrationTest {

	@Test
	public void switchOnEachLedInSequence() throws InterruptedException {
		for (int y = 1; y < 8; y++) {
			for (int x = 1; x < 8; x++) {
				Unicorn unicorn = new NeoPixelDisplayMatrix();
				unicorn.setPixelColor(x, y, Color.magenta);
				unicorn.show();
				sleep(500, MILLISECONDS);
			}
		}
		SECONDS.sleep(5);
	}

}
