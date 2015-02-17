package bad.robot.unicorn.integration;

import bad.robot.unicorn.neopixel.NeoPixelDisplayMatrix;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static java.lang.String.format;

/**
 * The tiny 8x8 chars in lofi.png are from Oddball http://forums.tigsource.com/index.php?topic=8834.0
 * <p>
 * Licensed under Creative Commons Attribution-Noncommercial-Share Alike 3.0 Unported License.
 */
public class LowFidelityImageLoadIntegrationTest {

    public static final int width = 8;

    @Test
    public void displayLoFiImages() throws IOException {
        SpriteSheet sheet = new SpriteSheet(16, 18, 8, 8);
        BufferedImage[] images = sheet.subImages("/lofi.png");

        List<Coordinate> u = range(0, 7).boxed().flatMap(x -> range(0, 7).mapToObj(y -> new Coordinate(x, y))).collect(toList());

        Arrays.stream(images).forEach(image -> {
            Stream<Coordinate> _8x8 = range(0, 7).boxed().flatMap(x -> range(0, 7).mapToObj(y -> new Coordinate(x, y)));
        });
    }


    private List<List<Coordinate>> splitImages() {
        int imageWidthPixels = 128;
        int imageHeightPixels = 144;

        List<List<Coordinate>> images = new ArrayList<>();

        for (int o_y = 0; o_y < imageHeightPixels / width; o_y++) {
            for (int o_x = 0; o_x < imageWidthPixels / width; o_x++) {
                List<Coordinate> image = new ArrayList<>();
                for (int y = 0; y < width; y++) {
                    for (int x = 0; x < width; x++) {
                        image.add(new Coordinate((o_x * width) + y, (o_y * width) + x));
                    }
                }
                images.add(image);
            }
        }

        return images;
    }

    class Coordinate {
        final int x;
        final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return format("(%s, %s)", x, y);
        }
    }
}
