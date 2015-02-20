package bad.robot.unicorn.neopixel;

import bad.robot.unicorn.Orientation;
import org.junit.Test;

import static bad.robot.unicorn.Orientation.*;
import static bad.robot.unicorn.Orientation.UP;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PixelIndexMatrixTest {

	private final PixelIndexMatrix indices = new PixelIndexMatrix();

	@Test(expected = RuntimeException.class)
	public void invalidCoordinate() {
		indices.getIndexFrom(0, 8, UP);
	}

	@Test
	public void noRotation() {
		assertThat(indices.getIndexFrom(0, 0, UP), is(7L));
		assertThat(indices.getIndexFrom(7, 7, UP), is(63L));
	}

	@Test
	public void shouldRotateNinetyDegreesClockwise() {
		assertThat(indices.getIndexFrom(0, 0, DOWN), is(56L));
		assertThat(indices.getIndexFrom(7, 7, DOWN), is(0L));
	}

	@Test
	public void shouldRotateOneHundredAndEightyDegreesClockwise() {
		assertThat(indices.getIndexFrom(0, 0, GPIO_DOWN), is(63L));
		assertThat(indices.getIndexFrom(7, 7, GPIO_DOWN), is(7L));
	}

	@Test
	public void shouldRotateTwoHundredAndSevntyDegreesClockwise() {
		assertThat(indices.getIndexFrom(0, 0, GPIO_LEFT), is(0L));
		assertThat(indices.getIndexFrom(7, 7, GPIO_LEFT), is(56L));
	}

}