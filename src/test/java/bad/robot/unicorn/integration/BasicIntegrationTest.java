package bad.robot.unicorn.integration;

import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.PlatformSafeUnicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import org.junit.Test;

import java.awt.*;

import static bad.robot.unicorn.Sleep.sleep;
import static bad.robot.unicorn.integration.CommandLine.*;
import static bad.robot.unicorn.neopixel.PlatformSafeUnicorn.createPlatformSafeUnicorn;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BasicIntegrationTest {

	@Test
	public void switchOnEachLedInSequence() throws InterruptedException {
        switchOnEachLedInSequence(createPlatformSafeUnicorn(Ws2811Unicorn::new));
	}

    private void switchOnEachLedInSequence(Unicorn unicorn) {
		unicorn.setBrightness(0.02);
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                unicorn.setPixelColor(x, y, new Color(255, 0, 255));
                unicorn.show();
                sleep(50, MILLISECONDS);
            }
        }
        sleep(1, SECONDS);
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				unicorn.setPixelColor(x, y, new Color(0, 0, 0));
				unicorn.show();
				sleep(50, MILLISECONDS);
			}
		}
        unicorn.shutdown();
    }

    public static void main(String... args) throws InterruptedException {
        new BasicIntegrationTest().switchOnEachLedInSequence(createUnicorn(args));
    }

}
