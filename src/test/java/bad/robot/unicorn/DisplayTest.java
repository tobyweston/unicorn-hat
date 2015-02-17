package bad.robot.unicorn;

import bad.robot.unicorn.neopixel.Display;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DisplayTest {

	private final Display display = new Display();

	@Test (expected = RuntimeException.class)
	public void invalidCoordinate() {
		display.getIndexFrom(0, 8);
	}

	@Test
	public void noRotation() {
		display.rotate(Orientation.GPIO_UP);
		assertThat(display.getIndexFrom(0, 0), is(7L));
		assertThat(display.getIndexFrom(7, 7), is(63L));
	}

	@Test
	public void shouldRotateNinetyDegreesClockwise() {
		display.rotate(Orientation.GPIO_RIGHT);
		assertThat(display.getIndexFrom(0, 0), is(56L));
		assertThat(display.getIndexFrom(7, 7), is(0L));
	}

	@Test
	public void shouldRotateOneHundredAndEightyDegreesClockwise() {
		display.rotate(Orientation.GPIO_DOWN);
		assertThat(display.getIndexFrom(0, 0), is(63L));
		assertThat(display.getIndexFrom(7, 7), is(7L));
	}

	@Test
	public void shouldRotateTwoHundredAndSevntyDegreesClockwise() {
		display.rotate(Orientation.GPIO_LEFT);
		assertThat(display.getIndexFrom(0, 0), is(0L));
		assertThat(display.getIndexFrom(7, 7), is(56L));
	}


}