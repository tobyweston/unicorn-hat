package bad.robot.unicorn;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public interface Gaussian {

    public static float[][] create(double fullWidthHalfMax, double centerX, double centerY) {
        float[][] result = new float[8][8];

        range(0, 8).forEach(x -> {
            range(0, 8).forEach(y -> {
                double a = x - centerX;
                double b = y - centerY;
                result[x][y] = (float) (-4 * Math.log(2) * Math.pow(a, 2 + Math.pow(b, 2) / Math.pow(fullWidthHalfMax, 2)));
            });
        });

        return result;
    }


}
