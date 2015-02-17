package bad.robot.unicorn.integration;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.AffineTransformOp.TYPE_BILINEAR;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.util.stream.IntStream.range;

public class SpriteSheet {

    private final int rows;
    private final int columns;
    private final int width;
    private final int height;

    public SpriteSheet(int rows, int columns, int width, int height) {
        this.rows = rows;
        this.columns = columns;
        this.width = width;
        this.height = height;
    }

    public BufferedImage[] subImages(String filename) throws IOException {
        BufferedImage image = ImageIO.read(getClass().getResource(filename));

        BufferedImage[] sprites = new BufferedImage[rows * columns];

        range(0, rows).forEach(row ->
            range(0, columns).forEach(column -> {
                sprites[(row * columns) + column] = image.getSubimage(row * width, column * height, width, height);
            })
        );

        return sprites;
    }

    public static void main(String... args) throws IOException {
        SpriteSheet sheet = new SpriteSheet(16, 18, 8, 8);
        BufferedImage[] images = sheet.subImages("/lofi.png");
        int numerOfImages = 10; // images.length;
        for (int i = 0; i < numerOfImages; i++) {
            if (images[i] != null) {
                ImageIO.write(images[i], "png", new File(String.format("test-%s.png", i)));
            }
        }
    }

    private static BufferedImage enlarge(BufferedImage before) {
        int w = before.getWidth();
        int h = before.getHeight();
        BufferedImage after = new BufferedImage(w, h, TYPE_INT_ARGB);
        AffineTransform transformation = new AffineTransform();
        transformation.scale(4.0, 4.0);
        AffineTransformOp scaleOp = new AffineTransformOp(transformation, TYPE_BILINEAR);
        return scaleOp.filter(before, after);
    }
}