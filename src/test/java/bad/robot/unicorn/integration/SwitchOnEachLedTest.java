package bad.robot.unicorn.integration;

import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import org.junit.Test;

import java.awt.*;

import static java.util.concurrent.TimeUnit.*;

public class SwitchOnEachLedTest {

	@Test
	public void shouldSwitchOnEachLedInSequence() throws InterruptedException {
		for (int y = 1; y < 8; y++) {
			for (int x = 1; x < 8; x++) {
				NeoPixelDisplayMatrix display = new NeoPixelDisplayMatrix();
				display.setPixelColor(x, y, Color.magenta);
				// ws2812.show();
				MILLISECONDS.sleep(500);
			}
		}
		SECONDS.sleep(5);
	}

}
