package def.protractor.protractor;

import java.util.function.Consumer;

import def.jasmine.DoneFn;
import def.selenium.webdriver.promise;

public abstract class ProtractorBrowser {

	public native promise.Promise<?> get(String destination);

	/**
	 * This method don't like that from angular testing. Here the function looks
	 * compiled in runtime and not well integrated with other part of the program.
	 * <br>
	 * Do not use this, this is error-prone and tricky needed.
	 * 
	 * @param func
	 * @return
	 */
	@Deprecated
	public native promise.Promise<?> executeAsyncScript(Consumer<DoneFn> func);
}
