package def.jasmine.jasmine;

import jsweet.lang.Interface;

@Interface
public abstract class Matchers<T> {

	public native boolean toBe(Object expected);

	public native boolean toEqual(Object expected);

	public native boolean toMatch(String string);

	public native boolean toBeDefined();

	public native boolean toBeUndefined();

	public native boolean toBeNull();

	public native boolean toBeNaN();

	public native boolean toBeTruthy();

	public native boolean toBeFalsy();

	public native boolean toHaveBeenCalled();

	public native boolean toHaveBeenCalledBefore(Spy spy);

	public native boolean toHaveBeenCalledWith(Object[] params);

	public native boolean toHaveBeenCalledTimes(Number number);

	public native boolean toContain(Object any);

	public native boolean toBeLessThan(Number number);

	public native boolean toBeLessThanOrEqual(Number number);

	public native boolean toBeGreaterThan(Number number);

	public native boolean toBeGreaterThanOrEqual(Number number);

	public native boolean toThrow();

	//
	public native boolean toBe(Object expected, Object failOutput);

	public native boolean toEqual(Object expected, Object failOutput);

	public native boolean toMatch(String string, Object failOutput);

	public native boolean toBeDefined(Object failOutput);

	public native boolean toBeUndefined(Object failOutput);

	public native boolean toBeNull(Object failOutput);

	public native boolean toBeNaN(Object failOutput);

	public native boolean toBeTruthy(Object failOutput);

	public native boolean toBeFalsy(Object failOutput);

	public native boolean toContain(Object any, Object failOutput);

	public native boolean toBeLessThan(Number number, Object failOutput);

	public native boolean toBeLessThanOrEqual(Number number, Object failOutput);

	public native boolean toBeGreaterThan(Number number, Object failOutput);

	public native boolean toBeGreaterThanOrEqual(Number number, Object failOutput);

	public native boolean toThrow(Object failOutput);
}
