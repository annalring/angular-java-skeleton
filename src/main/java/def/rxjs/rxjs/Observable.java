package def.rxjs.rxjs;

import def.libes5.Promise;

public abstract class Observable<T> {

	public native Promise<T> toPromise();
}
