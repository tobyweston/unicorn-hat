package bad.robot.unicorn.neopixel.ws2811;

import static java.util.stream.IntStream.range;

public class AdafruitNeoPixel {

	private final ws2811_t leds = new ws2811_t();
	private final ws2811_channel_t channel;

	/**
	 * @param count number of LED pixels
	 * @param pin GPIO pin connected to the pixels (must support PWM!)
	 * @param freqHz LED signal frequency in hertz (usually 800000hz)
	 * @param dma  DMA channel to use for generating signal (try 5)
	 * @param invert true to invert the signal (when using NPN transistor level shift)
	 * @param brightness Set to 0 for darkest and 255 for brightest
	 * @param channel the PWM channel to use
	 */
	AdafruitNeoPixel(int count, int pin, int freqHz, int dma, boolean invert, int brightness, int channel) {
        this.channel = rpi_ws281x.ws2811_channel_get(leds, channel);
        initialiseChannels();
        initialiseCurrentChannel(count, pin, invert, brightness);
		initialiseController(freqHz, dma);
	}

	void begin() {
		int result = rpi_ws281x.ws2811_init(leds);
		if (result != 0)
			throw new RuntimeException("ws2811_init failed with code " + result);
	}

	void setBrightness(double brightness) {
		channel.setBrightness((int) (brightness * 255.0));
	}

	void setPixelColor(int pixel, short red, short green, short blue) {
		long colour = (red << 16) | (green << 8) | blue;
		rpi_ws281x.ws2811_led_set(channel, pixel, colour);
	}

	void show() {
		int result = rpi_ws281x.ws2811_render(leds);
		if (result != 0)
			throw new RuntimeException("ws2811_render failed with code " + result);
	}

	double getBrightness() {
		return channel.getBrightness();
	}

	void cleanup() {
		rpi_ws281x.ws2811_fini(leds);
		leds.delete();
	}

	private void initialiseController(int freqHz, int dma) {
		leds.setFreq(freqHz);
		leds.setDmanum(dma);
	}

	private void initialiseChannels() {
		range(0, 2).forEach(number -> {
			ws2811_channel_t channel = rpi_ws281x.ws2811_channel_get(leds, number);
			channel.setCount(0);
			channel.setGpionum(0);
			channel.setInvert(0);
			channel.setBrightness(0);
		});
	}

	private void initialiseCurrentChannel(int count, int pin, boolean invert, int brightness) {
		this.channel.setCount(count);
		this.channel.setGpionum(pin);
		this.channel.setInvert(invert ? 1 : 0);	 // 0 if not invert else 1
		this.channel.setBrightness(brightness);
	}

}
