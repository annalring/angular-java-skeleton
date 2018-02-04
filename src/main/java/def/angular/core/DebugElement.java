package def.angular.core;

import def.dom.Element;

public class DebugElement extends DebugNode {

	public Element nativeElement;
	
	public native void triggerEventHandler(String eventName, Object eventObj);

	public native DebugElement query(Predicate<DebugElement> css);
}
