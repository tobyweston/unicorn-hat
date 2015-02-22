package bad.robot.unicorn.neopixel;

import org.junit.Test;

import static bad.robot.unicorn.Orientation.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PixelIndexMatrixTest {

	private final PixelIndexMatrix indices = new PixelIndexMatrix();

	@Test(expected = RuntimeException.class)
	public void invalidCoordinate() {
		indices.getIndexFrom(0, 8, UP);
	}

	@Test
	public void shouldPointUp() {
		assertThat(indices.getIndexFrom(0, 0, UP), is(7L));
		assertThat(indices.getIndexFrom(2, 3, UP), is(20L));
		assertThat(indices.getIndexFrom(6, 6, UP), is(49L));
		assertThat(indices.getIndexFrom(7, 7, UP), is(63L));
	}

	@Test
	public void shouldPointRight() {
		assertThat(indices.getIndexFrom(0, 0, RIGHT), is(0L));
		assertThat(indices.getIndexFrom(2, 3, RIGHT), is(29L));
		assertThat(indices.getIndexFrom(6, 6, RIGHT), is(54L));
		assertThat(indices.getIndexFrom(7, 7, RIGHT), is(56L));
	}

	@Test
	public void shouldPointDown() {
		assertThat(indices.getIndexFrom(0, 0, DOWN), is(63L));
		assertThat(indices.getIndexFrom(2, 3, DOWN), is(44L));
		assertThat(indices.getIndexFrom(6, 6, DOWN), is(9L));
		assertThat(indices.getIndexFrom(7, 7, DOWN), is(7L));
	}

	@Test
	public void shouldPointLeft() {
		assertThat(indices.getIndexFrom(0, 0, LEFT), is(56L));
		assertThat(indices.getIndexFrom(2, 3, LEFT), is(37L));
		assertThat(indices.getIndexFrom(6, 6, LEFT), is(14L));
		assertThat(indices.getIndexFrom(7, 7, LEFT), is(0L));
	}

}