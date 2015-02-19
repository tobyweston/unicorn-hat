package bad.robot.unicorn.integration;

import bad.robot.unicorn.StubUnicorn;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import org.junit.Test;

import java.awt.*;

import static bad.robot.unicorn.Sleep.sleep;
import static java.util.concurrent.TimeUnit.*;

public class BasicIntegrationTest {

	@Test
	public void switchOnEachLedInSequence() throws InterruptedException {
		Unicorn unicorn = new NeoPixelDisplayMatrix();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				unicorn.setPixelColor(x, y, Color.magenta);
				unicorn.show();
				sleep(500, MILLISECONDS);
			}
		}
		SECONDS.sleep(5);
	}

	public static void main(String... args) throws InterruptedException {
		new BasicIntegrationTest().switchOnEachLedInSequence();
	}

}
