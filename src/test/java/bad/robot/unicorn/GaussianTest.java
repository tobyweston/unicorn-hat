package bad.robot.unicorn;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GaussianTest {

    @Test
    public void shouldCreateMatrix() {
        float[][] expected = new float[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        float[][] gauss = Gaussian.create(0.5, 3.5, 3.5);

        assertThat(gauss.length, is(8));
        assertThat(gauss[0].length, is(8));

        for (float[] g : gauss)
            System.out.println(Arrays.toString(g));
    }

}