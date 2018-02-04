package def.angular.core_testing;

import java.util.function.Consumer;

public abstract class Globals {

	public static native void tick();

	public static native void tick(double time);

	public static native <T> Consumer<T> async(Runnable run);

	public static native <T> Consumer<T> fakeAsync(Runnable run);
}
