package bad.robot.unicorn.neopixel;

class Platform {

	private static boolean logged = false;

	static boolean runningOnPi() {
		boolean pi = System.getProperty("os.name").contains("Linux") && System.getProperty("os.arch").equals("arm");
		if (!pi && !logged) {
			System.out.println("WARNING: Not even trying to use the ws2812 C library, you're not running on the Pi");
			logged = true;
		}
		return pi;
	}

}
