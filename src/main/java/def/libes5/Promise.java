package def.libes5;

import java.util.function.Consumer;
import java.util.function.Function;

import jsweet.lang.Name;

public abstract class Promise<T> {

	public native Promise<T> then(Consumer<T> fun);

	public native <R> Promise<T> then(Function<T, R> fun);

	@Name("catch")
	public native Promise<T> _catch(Consumer<Object> fun);
	
	@Name("catch")
	public native <R> Promise<T> _catch(Function<Object, R> fun);

}
