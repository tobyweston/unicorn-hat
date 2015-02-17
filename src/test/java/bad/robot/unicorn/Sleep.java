package bad.robot.unicorn;

import java.util.concurrent.TimeUnit;

public class Sleep {
	public static void sleep(int period, TimeUnit time) {
		try {
			time.sleep(period);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
