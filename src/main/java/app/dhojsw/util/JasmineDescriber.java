package app.dhojsw.util;

import java.util.function.Consumer;

import def.jasmine.DoneFn;
import def.jasmine.jasmine.Matchers;

/**
 * 
 * @author Wu
 *
 */
public class JasmineDescriber implements Runnable {

	protected String desc;
	
	public JasmineDescriber() {
		this.desc = this.getClass().getName();
	}
	
	public JasmineDescriber(String desc) {
		this.desc = desc;
	}

	/**
	 * 
	 */
	public void describe() {

		Jasmine_.describe_(this.desc, () -> {
			this.run();
		});
	}

	protected JasmineDescriber it(String desc, Consumer<DoneFn> func) {
		Jasmine_.it_(desc, func);
		return this;
	}

	protected JasmineDescriber it(String desc, Runnable func) {
		Jasmine_.it_(desc, func);
		return this;
	}

	protected JasmineDescriber beforeEach(Runnable run) {
		Jasmine_.beforeEach_(run);
		return this;
	}

	public <T> Matchers<T> expect(T obj) {
		return Jasmine_.expect_(obj);
	}

	@Override
	public void run() {

	}

}
