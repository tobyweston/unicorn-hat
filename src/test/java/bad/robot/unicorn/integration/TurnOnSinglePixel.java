package bad.robot.unicorn.integration;

import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2812.Ws2812Unicorn;

import java.util.concurrent.TimeUnit;

import static java.awt.Color.BLUE;
import static java.lang.Integer.parseInt;
import static java.util.concurrent.TimeUnit.*;

public class TurnOnSinglePixel {

	public static void main(String... args) {
		Unicorn unicorn = CommandLine.createUnicorn(args);
		if (args.length == 0)
			unicorn.clear();
		if (args.length > 2)
			unicorn.setPixelColor(parseInt(args[0]), parseInt(args[1]), BLUE);
		unicorn.show();
        Sleep.sleep(2, SECONDS);
        unicorn.clear();
    }
}
