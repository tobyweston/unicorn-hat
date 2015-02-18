package bad.robot.unicorn.integration.jni;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class LdLibraryPathTest {

	@Test
	public void sharedObjectShouldLoad() {
		String time = example.get_time();
		System.out.println("*******************************************************");
		System.out.println("* Current time via JNI is :    " + time);
		System.out.println("*******************************************************");
	}

	@Test
	public void canSeeEnvironmentVariablesFromTest() {
		String path = System.getenv("LD_LIBRARY_PATH");
		assertThat(path, is(not(nullValue())));
		System.out.println("*******************************************************");
		System.out.println("* LD_LIBRARY_PATH as seen by the test : ");
		System.out.println("* " + path);
		System.out.println("*******************************************************");
	}

	@Test
	public void canSeeJavaLibraryPath() {
		String path = System.getProperty("java.library.path");
		assertThat(path, containsString("swig_example"));
		System.out.println("*******************************************************");
		System.out.println("* java.library.path as seen by the test : ");
		System.out.println("* " + path);
		System.out.println("*******************************************************");
	}


}
