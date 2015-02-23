package bad.robot.unicorn;

import static java.util.stream.IntStream.range;

public interface Gaussian {

    public static double[][] create(double radius, double centerX, double centerY) {
        double[][] result = new double[8][8];

        range(0, 8).forEach(x -> {
            range(0, 8).forEach(y -> {
                double a = x - centerX;
                double b = y - centerY;
				result[x][y] = Math.exp(-4 * Math.log(2) * (Math.pow(a, 2) + Math.pow(b, 2)) / Math.pow(radius, 2));
			});
        });

        return result;
    }


}
