package bad.robot.unicorn.integration;

import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.neopixel.ws2811.Ws2811Unicorn;
import bad.robot.unicorn.neopixel.ws2812.Ws2812Unicorn;

public class CommandLine {
    public static Unicorn createUnicorn(String... args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("ws2812")) {
            System.out.println("Using ws2812 driver (pass in 'ws2812' for 'ws2812' for ws2812)");
            return new Ws2812Unicorn();
        } else {
            System.out.println("Using ws2811/ws281x driver (pass in 'ws2812' for 'ws2812' for ws2812)");
            return new Ws2811Unicorn();
        }
    }
}
