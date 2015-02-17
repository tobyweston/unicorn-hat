package bad.robot.unicorn.integration.jni;

import org.junit.Test;

public class LdLibraryPathIntegrationTest {

	@Test
	public void sharedObjectShouldLoad() {
		System.out.println("******************************************************");
		System.out.println("* Current time via JNI is :    " + example.get_time());
		System.out.println("******************************************************");
	}

}
