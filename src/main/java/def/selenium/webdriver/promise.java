package def.selenium.webdriver;

import jsweet.lang.Interface;

/**
 * Note, the caller must import the outer most class, for that it is a
 * namespace. <code>
 * import def.selenium.webdriver.promise;
 * </code>
 * 
 * @author Wu
 *
 */
public class promise {
	@Interface
	public static class IThenable<T> {

	}

	public static class Promise<T> extends IThenable<T> {

	}
}
