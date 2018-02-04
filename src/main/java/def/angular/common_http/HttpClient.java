package def.angular.common_http;

import def.rxjs.rxjs.Observable;

public abstract class HttpClient {

	public native <T> Observable<T> post(String url, Object body);
}
