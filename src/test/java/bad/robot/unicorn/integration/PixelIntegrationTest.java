package bad.robot.unicorn.integration;

import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;

import static java.awt.Color.BLUE;
import static java.lang.Integer.parseInt;

public class PixelIntegrationTest {

	public static void main(String... args) {
		Unicorn unicorn = new NeoPixelDisplayMatrix();
		if (args.length == 0)
			unicorn.clear();
		if (args.length > 2)
			unicorn.setPixelColor(parseInt(args[0]), parseInt(args[1]), BLUE);
		unicorn.show();
	}
}
