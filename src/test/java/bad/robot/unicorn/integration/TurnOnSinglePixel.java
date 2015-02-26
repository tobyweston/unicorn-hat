package bad.robot.unicorn.integration;

import bad.robot.unicorn.Sleep;
import bad.robot.unicorn.Unicorn;

import java.awt.*;

import static java.lang.Integer.parseInt;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TurnOnSinglePixel {

	public static void main(String... args) {
		Unicorn unicorn = CommandLine.createUnicorn(args);
		if (args.length == 0)
			unicorn.clear();
		if (args.length > 2)
			unicorn.setPixelColor(parseInt(args[0]), parseInt(args[1]), new Color(0, 0, 255));
		unicorn.show();
        Sleep.sleep(2, SECONDS);
        unicorn.clear();
    }
}
