package def.jasmine;

import java.util.function.Consumer;

import def.jasmine.jasmine.ArrayLikeMatchers;
import def.jasmine.jasmine.Matchers;
import def.js.ArrayLike;

public class Globals {
	public native static void describe(String desc, Runnable fun);

	/**
	 * Asynchronously running a test task.
	 * 
	 * @param desc
	 * @param run
	 */
	public static native void it(String desc, Consumer<DoneFn> run);

	/**
	 * Synchronously running a test task.
	 * 
	 * @param desc
	 * @param run
	 */
	public static native void it(String desc, Runnable run);

	public static native <T> Matchers<T> expect(T obj);

	/**
	 * This method is a sugar,string is a ArrayLike in TS. So this is actually the
	 * same, in generated TS code, as another expect method.
	 * 
	 * @param obj
	 * @return
	 */
	public static native <T> ArrayLikeMatchers<T> expect(String str);

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static native <T> ArrayLikeMatchers<T> expect(ArrayLike<T> obj);

	public static native void beforeEach(Consumer<DoneFn> action);

	public static native void beforeEach(Runnable action);
}
