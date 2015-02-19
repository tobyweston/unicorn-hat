package bad.robot.unicorn;

import java.awt.*;

public interface Unicorn {

    void setPixelColor(int x, int y, Color color);

    void show();

    void rotate(Orientation orientation);

	void clear();

	void shutdown();
}
