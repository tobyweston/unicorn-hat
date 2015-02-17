package bad.robot.unicorn.integration.jni;

import org.junit.Test;

public class LdLibraryPathTest {

	@Test
	public void sharedObjectShouldLoad() {
		System.out.println("******************************************************");
		System.out.println("* Current time via JNI is :    " + example.get_time());
		System.out.println("******************************************************");
	}

}
