package app.dhojsw.ng.service;

import app.dhojsw.util.JasmineDescriber;
import def.angular.core_testing.TestBed;
import def.angular.core_testing.TestModuleMetadata;

public class LoggerSpec extends JasmineDescriber {

	public static void main(String[] args) {
		new LoggerSpec("Logger Test").describe();
	}

	Logger logger;

	public LoggerSpec(String desc) {
		super(desc);
	}

	@Override
	public void run() {

		this.beforeEach(() -> {
			TestModuleMetadata meta = new TestModuleMetadata();
			meta.providers = new Class<?>[] { Logger.class };
			TestBed.configureTestingModule(meta);
			TestBed.compileComponents();
			logger = TestBed.get(Logger.class);
		});

		this.it("Assert logger is injected.", (done) -> {
			this.expect(this.logger).toBeTruthy("Logger not able being injected.");
			this.logger.debug("debug msg");
			this.logger.info("info msg");
			this.logger.warn("warn msg");
			this.logger.error("error msg");
			done.$apply();
		});
	}
}
