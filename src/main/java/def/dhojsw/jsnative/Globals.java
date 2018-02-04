package def.dhojsw.jsnative;

/**
 * @author wu
 *
 */
public abstract class Globals {

//	// angular
//	/**
//	 * the target ts method is async(Function fn) : ()=>void; <br>
//	 * while the generated one is async(()=>void) : ()=>void; <br>
//	 * not match so we bridge them.
//	 * 
//	 * @param run
//	 * @return
//	 */
//	public static native <T> Consumer<T> angular_async(Runnable run);
//
//	public static native <T> Consumer<T> angular_fakeAsync(Runnable run);

	// jasmine
	

	

	public static native boolean js_isNumber(Object jso);

}
