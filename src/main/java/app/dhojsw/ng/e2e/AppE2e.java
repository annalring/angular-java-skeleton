package app.dhojsw.ng.e2e;

import static def.protractor.protractor.Globals.browser;
import static def.protractor.protractor.Globals.by;
import static def.protractor.protractor.Globals.element;

import java.util.function.Consumer;

import app.dhojsw.util.JasmineDescriber;
import def.jasmine.DoneFn;
import def.protractor.protractor.ElementFinder;
import def.selenium.webdriver.By;
import def.selenium.webdriver.promise;

public class AppE2e extends JasmineDescriber {
	private static class MyFunction implements Consumer<DoneFn> {

		@Override
		public void accept(DoneFn t) {

		}

	}

	public AppE2e() {
		super();
	}

	public static void main(String[] args) {
		new AppE2e().describe();
	}

	public void $apply(DoneFn done) {
		browser.get("/");
		done.$apply();
	}

	@Override
	public void run() {

		this.it("test task asynchronously", () -> {
			promise.Promise<?> pro = browser.get("/");
			By byy = by.css("app-root h1");
			ElementFinder ef = element.$apply(byy);
			promise.Promise<String> text = ef.getText();
			this.expect(text).toBeTruthy();
			// done.$apply();
		});

		this.it("test browser.executeAsyncScript", (done) -> {
			browser.executeAsyncScript(new Consumer<DoneFn>() {

				@Override
				public void accept(DoneFn t) {
					t.$apply();
				}
			});
			done.$apply();
		});

	}

}
