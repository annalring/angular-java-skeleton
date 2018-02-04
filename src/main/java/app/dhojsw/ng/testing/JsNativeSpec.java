package app.dhojsw.ng.testing;

import static def.dhojsw.jsnative.Globals.js_isNumber;
import static def.jasmine.Globals.describe;
import static def.jasmine.Globals.expect;
import static def.jasmine.Globals.it;

import java.util.function.Consumer;

import def.jasmine.DoneFn;
import def.jasmine.jasmine.ArrayLikeMatchers;

public class JsNativeSpec {
	
	public static void main(String[] args) {
		describe("JsNativeSpec Test1:Some native test", new Runnable() {
			@Override
			public void run() {

				it("js_isNumber() method test", new Consumer<DoneFn>() {

					@Override
					public void accept(DoneFn t) {
						boolean yes = js_isNumber(1.1);
						expect(yes).toBe(true);
						t.$apply();
					}

				});
			}
		});
		describe("JsNativeSpec Test2: String expect test", new Runnable() {
			@Override
			public void run() {
				it("expect String", (done) -> {

					ArrayLikeMatchers<String> matchers = expect("hello");
					matchers.toBeTruthy("Not truth");
					done.$apply();
				});
			}
		});

	}
}
