package def.angular.router;

import jsweet.lang.Interface;

@Interface
public class ParamMap {
	public native boolean has(String key);

	public native String get(String key);

	public native String[] getAll();
}
