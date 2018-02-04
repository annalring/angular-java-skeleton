package app.dhojsw.ng.util;

import java.util.function.Consumer;

import app.dhojsw.util.Jasmine_;
import def.jasmine.DoneFn;
import def.jasmine.jasmine.Matchers;
import jsweet.lang.Optional;

/**
 * Usage as a example:<br>
 * <code>
 * public class LoggerSpec extends UnitDescriber {
 *
 *	public static void main(String[] args) {
 *		new LoggerSpec("Logger Test").describe();
 *	}
 *
 *	Logger logger;
 *
 *	public LoggerSpec(String desc) {
 *		super(desc);
 *	}
 *
 *	&#64;Override
 *	public void run() {
 *
 *		this.beforeEach(() -> {
 *			TestModuleMetadata meta = new TestModuleMetadata();
 *			meta.providers = new Class<?>[] { Logger.class };
 *			TestBed.configureTestingModule(meta);
 *			TestBed.compileComponents();
 *			logger = TestBed.get(Logger.class);
 *		});
 *
 *		this.it("Assert logger is injected.", (done) -> {
 *			this.expect(this.logger).toBeTruthy("Logger not able being injected.");
 *			this.logger.debug("debug msg");
 *			this.logger.info("info msg");
 *			this.logger.warn("warn msg");
 *			this.logger.error("error msg");
 *			done.$apply();
 *		});
 *	}
 * }
 * </code>
 * 
 * @author Wu
 *
 */
public class AngularUnitDescriber implements Runnable {

	protected String desc;

	public AngularUnitDescriber() {
		this.desc = this.getClass().getName();
	}

	public AngularUnitDescriber(String desc) {
		this.desc = desc;
	}

	public <T> Consumer<T> async(Runnable run) {
		return Angular_.async_(run);
	}

	public <T> Consumer<T> fakeAsync(Runnable run) {
		return Angular_.fakeAsync_(run);
	}

	public void tick() {
		Angular_.tick_();
	}

	public void tick(@Optional double time) {
		Angular_.tick_(time);
	}

	/**
	 * 
	 */
	public void describe() {

		Jasmine_.describe_(this.desc, () -> {
			this.run();
		});
	}

	protected AngularUnitDescriber itFakeAsync(String desc, Runnable func) {
		Jasmine_.it_(desc, Angular_.fakeAsync_(func));
		return this;
	}

	protected AngularUnitDescriber itAsync(String desc, Runnable func) {
		Jasmine_.it_(desc, Angular_.async_(func));
		return this;
	}

	protected AngularUnitDescriber it(String desc, Runnable func) {
		Jasmine_.it_(desc, func);
		return this;
	}

	protected AngularUnitDescriber it(String desc, Consumer<DoneFn> func) {
		Jasmine_.it_(desc, func);
		return this;
	}

	protected AngularUnitDescriber beforeEach(Runnable run) {
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
