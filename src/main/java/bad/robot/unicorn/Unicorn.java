package bad.robot.unicorn;

import java.awt.*;

public interface Unicorn {

    void setPixelColor(int x, int y, Color color);

	void setPixelColor(long pixel, Color color);

	void setBrightness(double brightness);

	double getBrightness();

    void show();

    void rotate(Orientation orientation);

	void clear();

	void shutdown();
}
