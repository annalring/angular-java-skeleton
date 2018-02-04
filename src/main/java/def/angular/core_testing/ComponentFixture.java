package def.angular.core_testing;

import def.angular.core.DebugElement;

public class ComponentFixture<T> {
	public DebugElement debugElement;

	public T componentInstance;

	public Object nativeElement;

	/**
	 * What does detectChanges do? Why it shouldn't be called twice?
	 */
	public native void detectChanges();

}
