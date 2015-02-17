package bad.robot.unicorn;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
            range(0, columns).forEach(column ->
				sprites[(row * columns) + column] = image.getSubimage(row * width, column * height, width, height))
        );

        return sprites;
    }

    public static void main(String... args) throws IOException {
		save(new SpriteSheet(16, 18, 8, 8).subImages("/lofi.png"));
    }

	private static void save(BufferedImage[] images) throws IOException {
		int numberOfImages = 10; // images.length;
		for (int i = 0; i < numberOfImages; i++) {
			if (images[i] != null) {
				ImageIO.write(images[i], "png", new File(String.format("test-%s.png", i)));
			}
		}
	}

}