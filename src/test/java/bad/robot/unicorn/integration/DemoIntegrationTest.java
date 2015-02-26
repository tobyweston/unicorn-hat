package bad.robot.unicorn.integration;

import org.junit.Test;

public class DemoIntegrationTest {

    @Test
    public void swirlyGoodness() {

    }

    interface Effect {
        RawColour getColourFor(int x, int y, int step);
    }

    public class Swirl implements Effect {

        public RawColour getColourFor(int x, int y, int step) {
            x -= 4;
            y -= 4;

            double dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) - 2.0;
            double angle = (step / 10.0) + (dist * 1.5);
            double s = Math.sin(angle);
            double c = Math.cos(angle);

            double xs = x * c - y * s;
            double ys = x * s - y * c;

            double r = Math.abs(xs + ys);
            r *= 64.0;
            r -= 20;

            return new RawColour(r, r + (s * 130), r + (c * 130));
        }
    }

    class RawColour {
        final double red;
        final double green;
        final double blue;

        public RawColour(double red, double green, double blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

    }

}
